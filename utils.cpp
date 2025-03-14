#include "utils.hpp"

using json = nlohmann::json;
const int tableVersion = 0; // 从cdn直接下载的表版本为0, 游戏下载后的表为获取的版本号
const std::string keyMagic = "!@UmWlXo";

size_t QooAppAPI::WriteCallback(void *contents, size_t size, size_t nmemb, std::string *userp)
{
    userp->append((char *)contents, size * nmemb);
    return size * nmemb;
}

std::string QooAppAPI::httpGet(const std::string &url, int retries)
{
    std::string response;
    for (int attempt = 0; attempt < retries; ++attempt)
    {
        CURL *curl = curl_easy_init();
        if (curl)
        {
            curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
            curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, WriteCallback);
            curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

            // 添加 HTTP 头部以避免缓存
            struct curl_slist *headers = nullptr;
            headers = curl_slist_append(headers, "Cache-Control: no-cache");
            headers = curl_slist_append(headers, "Pragma: no-cache");
            headers = curl_slist_append(headers, "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
            curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);

            // 启用所有支持的编码类型
            curl_easy_setopt(curl, CURLOPT_ACCEPT_ENCODING, "");

            // 允许重定向
            curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
            curl_easy_setopt(curl, CURLOPT_MAXREDIRS, 3L);

            curl_easy_setopt(curl, CURLOPT_TIMEOUT, 10L);
            curl_easy_setopt(curl, CURLOPT_CONNECTTIMEOUT, 5L);
            curl_easy_setopt(curl, CURLOPT_NOSIGNAL, 1L);
            curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, 0L);
            curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, 0L);

            response.clear();
            CURLcode res = curl_easy_perform(curl);

            // 打印详细的请求信息
            char *effective_url = nullptr;
            curl_easy_getinfo(curl, CURLINFO_EFFECTIVE_URL, &effective_url);

            if (res != CURLE_OK)
            {
                curl_slist_free_all(headers);
                curl_easy_cleanup(curl);
                if (attempt < retries)
                {
                    std::this_thread::sleep_for(std::chrono::seconds(1));
                    continue;
                }
                return "";
            }

            long response_code;
            curl_easy_getinfo(curl, CURLINFO_RESPONSE_CODE, &response_code);
            if (response_code != 200)
            {
                curl_slist_free_all(headers);
                curl_easy_cleanup(curl);
                if (attempt < retries)
                {
                    std::this_thread::sleep_for(std::chrono::seconds(1));
                    continue;
                }
                return "";
            }

            curl_slist_free_all(headers);
            curl_easy_cleanup(curl);
            break;
        }
    }
    return response;
}

std::string QooAppAPI::findBetween(const std::string &str, const std::vector<std::string> &delimiters)
{
    size_t start = str.find(delimiters[0]);
    if (start == std::string::npos)
        return "";

    start = str.find(delimiters[1], start + delimiters[0].length());
    if (start == std::string::npos)
        return "";
    start += delimiters[1].length();

    size_t end = str.find(delimiters[2], start);
    if (end == std::string::npos)
        return "";

    return str.substr(start, end - start);
}

QooAppAPI::ApkInfo QooAppAPI::getApkInfo(const std::string &game_id)
{
    ApkInfo info;
    std::string url = "https://m-apps.qoo-app.com/en-US/app/" + game_id;
    std::string response = httpGet(url);

    std::vector<std::string> delimiters = {
        "window.__INITIAL_DATA__",
        "=",
        "; window.__INITIAL_LAYOUT_DATA__"};

    std::string json_str = findBetween(response, delimiters);
    std::regex undefined_regex("undefined");
    json_str = std::regex_replace(json_str, undefined_regex, "\"\"");

    json data = json::parse(json_str);
    info.version = data["app-detail-view"]["fetch"]["apk"]["versionName"];

    std::string package_id = data["app-detail-view"]["fetch"]["packageId"];
    std::string download_url = "https://api.ppaooq.com/v11/apps/" + package_id +
                               "/download?baseApkMd5=null&userId=0&baseApkVersion=0&type=app";

    CURL *curl = curl_easy_init();
    if (curl)
    {
        curl_easy_setopt(curl, CURLOPT_URL, download_url.c_str());
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 0L);
        curl_easy_setopt(curl, CURLOPT_NOBODY, 1L);
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, 0L);
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, 0L);

        struct curl_slist *headers = nullptr;
        headers = curl_slist_append(headers, "x-device-abis: x86_64,arm64-v8a,x86,armeabi-v7a,armeabi");
        headers = curl_slist_append(headers, "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);

        CURLcode res = curl_easy_perform(curl);
        if (res == CURLE_OK)
        {
            char *redirect_url = nullptr;
            if (curl_easy_getinfo(curl, CURLINFO_REDIRECT_URL, &redirect_url) == CURLE_OK && redirect_url)
            {
                info.apk_url = redirect_url;
            }
            else
            {
                std::println("\033[31m无法获取重定向 URL\033[0m");
                info.apk_url = "获取下载链接失败";
            }
        }
        else
        {
            std::println("\033[31mCURL 请求失败: {}\033[0m", curl_easy_strerror(res));
            info.apk_url = "获取下载链接失败";
        }

        curl_slist_free_all(headers);
        curl_easy_cleanup(curl);
    }
    return info;
}

// 通用进度显示函数
void updateProgressDisplay(const std::string &prefix, size_t current, size_t total,
                           const std::string &suffix, size_t *last_output_length)
{
    static size_t internal_last_length = 0;
    size_t &last_length = last_output_length ? *last_output_length : internal_last_length;

    // 清除上一次的输出
    std::cout << "\r" << std::string(last_length, ' ') << "\r";

    std::stringstream output;
    int percentage = static_cast<int>((current * 100.0) / total);

    output << prefix << ": [";
    for (int i = 0; i < 50; i++)
    {
        output << (i < (percentage / 2) ? "=" : " ");
    }
    output << "] " << percentage << "% ("
           << current << "/" << total << ")";

    if (!suffix.empty())
    {
        output << " " << suffix;
    }

    std::string output_str = output.str();
    std::cout << output_str << std::flush;
    last_length = output_str.length();
}

static int progressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow)
{
    if (dltotal <= 0)
        return 0;

    static size_t last_length = 0;
    updateProgressDisplay("下载进度", dlnow, dltotal, "", &last_length);

    return 0;
}

bool QooAppAPI::downloadFile(const std::string &url, const std::string &filepath)
{
    CURL *curl = curl_easy_init();
    if (!curl)
        return false;

    FILE *fp = fopen(filepath.c_str(), "wb");
    if (!fp)
    {
        curl_easy_cleanup(curl);
        return false;
    }

    curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
    curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, NULL);
    curl_easy_setopt(curl, CURLOPT_WRITEDATA, fp);
    curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);

    curl_easy_setopt(curl, CURLOPT_XFERINFOFUNCTION, progressCallback);
    curl_easy_setopt(curl, CURLOPT_NOPROGRESS, 0L);

    CURLcode res = curl_easy_perform(curl);

    fclose(fp);
    curl_easy_cleanup(curl);

    return (res == CURLE_OK);
}

QooAppAPI::TableInfo QooAppAPI::getTableInfo(const std::string &version)
{
    std::string url = "https://patch.esoul.kakaogames.com/Live/" + version + "/Table/const_data_version.json";
    std::string response = httpGet(url);

    json data = json::parse(response);
    TableInfo info;
    info.version = data["version"];
    info.action = data["action"];
    return info;
}

bool QooAppAPI::checkAndUpdateTables(const std::string &version)
{
    std::println("检查 Live 服务器数据表更新...");

    // 获取服务器上的实际版本信息
    std::string versionUrl = std::format("https://patch.esoul.kakaogames.com/Live/{}/Table/const_data_version.json", version);
    std::println("检查版本URL: {}", versionUrl);

    TableInfo tableInfo = getTableInfo(version);
    if (tableInfo.version == 0)
    {
        std::println("\033[31m获取数据表信息失败\033[0m");
        return false;
    }
    std::println("服务器数据表版本: {}", tableInfo.version);

    std::string hashUrl = std::format("https://patch.esoul.kakaogames.com/Live/{}/Android/catalog_eversoul.hash", version);
    std::println("检查哈希URL: {}", hashUrl);
    std::string currentHash = httpGet(hashUrl);
    std::println("服务器哈希值: {}", currentHash);

    fs::path table_info_path = "../table_info.json";
    json table_info;

    // 检查正式服数据表文件夹是否存在
    bool liveTablesExist = fs::exists("../live_tables") && !fs::is_empty("../live_tables");
    std::println("Live 数据表目录存在且非空: {}", liveTablesExist ? "是" : "否");

    if (fs::exists(table_info_path))
    {
        std::println("检查 table_info.json...");
        std::ifstream file(table_info_path);
        table_info = json::parse(file);

        if (table_info.contains("live"))
        {
            std::println("当前保存的信息:");
            std::println("版本: {}", table_info["live"]["version"].get<std::string>());
            std::println("表版本: {}", table_info["live"]["tableVersion"].get<int>());
            std::println("哈希值: {}", table_info["live"]["hash"].get<std::string>());
        }

        // 比较版本号和哈希值
        if (table_info.contains("live") &&
            table_info["live"]["version"] == version &&
            table_info["live"]["tableVersion"] == tableInfo.version &&
            table_info["live"]["hash"] == currentHash &&
            liveTablesExist)
        {
            std::println("\033[32mLive 服务器数据表已是最新版本\033[0m");
            return false;
        }
        else
        {
            std::println("需要更新数据表:");
            if (table_info.contains("live"))
            {
                if (table_info["live"]["tableVersion"] != tableInfo.version)
                    std::println("- 表版本不同: {} -> {}",
                                 table_info["live"]["tableVersion"].get<int>(), tableInfo.version);
                if (table_info["live"]["hash"] != currentHash)
                    std::println("- 哈希值不同");
            }
            else
            {
                std::println("- table_info.json 中没有 live 信息");
            }
        }
    }
    else
    {
        std::println("table_info.json 不存在，将创建新文件");
    }

    // 构建下载链接
    std::string zipUrl = std::format("https://patch.esoul.kakaogames.com/Live/{}/Table/data_{}.zip",
                                     version, tableInfo.version);
    std::println("下载URL: {}", zipUrl);
    std::string zipPath = "../data_" + std::to_string(tableInfo.version) + ".zip";

    // 添加下载重试逻辑
    const int maxRetries = 3;
    bool downloadSuccess = false;
    
    for (int retry = 1; retry <= maxRetries; retry++) {
        if (downloadFile(zipUrl, zipPath)) {
            downloadSuccess = true;
            break;
        }
        
        std::println("\033[33m下载失败，等待重试...\033[0m");
        // 重试前等待一段时间，避免频繁请求
        std::this_thread::sleep_for(std::chrono::seconds(2));
    }
    
    if (!downloadSuccess) {
        std::println("\033[31m下载数据表压缩包失败，已重试 {} 次\033[0m", maxRetries);
        return false;
    }

    if (!fs::exists("../live_tables"))
    {
        fs::create_directory("../live_tables");
    }
    std::string unzipCommand = "unzip -o " + zipPath + " -d ../live_tables/ > /dev/null 2>&1";
    system(unzipCommand.c_str());

    fs::remove(zipPath);

    // 解密正式服数据表
    std::vector<unsigned char> key, iv;
    if (!deriveKeyAndIv(key, iv))
    {
        std::println("\033[31m密钥派生失败\033[0m");
        return false;
    }

    std::vector<fs::path> files_to_decrypt;
    for (const auto &entry : fs::directory_iterator("../live_tables"))
    {
        if (entry.is_regular_file() && !isFileDecrypted(entry.path()))
        {
            files_to_decrypt.push_back(entry.path());
        }
    }

    if (!decryptFiles(files_to_decrypt, key, iv))
    {
        std::println("\033[31m正式服数据表解密失败\033[0m");
        return false;
    }

    // 转换正式服数据表
    if (!fs::exists("../live_jsons"))
    {
        fs::create_directory("../live_jsons");
    }
    if (!convertTablesToJson("../schemas", "../live_tables", "../live_jsons"))
    {
        std::println("\033[31m正式服数据表转换失败\033[0m");
        return false;
    }

    table_info["live"] = {
        {"version", version},
        {"tableVersion", tableInfo.version},
        {"hash", currentHash}};

    std::ofstream outFile(table_info_path);
    outFile << table_info.dump(4);

    std::println("\033[32mLive 服务器数据表已更新到最新版本\033[0m");
    return true;
}

/**
 * @brief 密钥派生函数
 * 
 * @param key 
 * @param iv 
 * @return true 
 * @return false 
 */
bool deriveKeyAndIv(std::vector<unsigned char> &key, std::vector<unsigned char> &iv)
{
    // 计算 (tableVersion ^ 0x80000000) 并作为有符号整数，生成一个基于tableVersion的唯一值
    int32_t xor_result = static_cast<int32_t>(tableVersion ^ 0x80000000);
    std::string unhashKey = std::to_string(xor_result) + keyMagic; // "-2147483648!@UmWlXo"

    // 使用SHA256算法对未哈希的密钥进行哈希处理
    unsigned char hash[SHA256_DIGEST_LENGTH];
    if (!SHA256(reinterpret_cast<const unsigned char *>(unhashKey.c_str()), unhashKey.size(), hash))
    {
        std::println("\033[31mSHA256 hashing 失败.\033[0m");
        return false;
    }

    // 前16个字节作为密钥
    key.assign(hash, hash + 16);
    // IV与密钥相同
    iv = key;

    return true;
}

/**
 * @brief aes128cbc解密
 * 
 * @param ciphertext 
 * @param plaintext 
 * @param key 
 * @param iv 
 * @return true 
 * @return false 
 */
bool decryptAes128Cbc(const std::vector<unsigned char> &ciphertext, std::vector<unsigned char> &plaintext,
                      const std::vector<unsigned char> &key, const std::vector<unsigned char> &iv)
{
    EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
    if (!ctx)
    {
        std::println("\033[31mEVP_CIPHER_CTX_new 失败！\033[0m");
        return false;
    }

    if (EVP_DecryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key.data(), iv.data()) != 1)
    {
        std::println("\033[31mEVP_DecryptInit_ex 失败！\033[0m");
        EVP_CIPHER_CTX_free(ctx);
        return false;
    }

    plaintext.resize(ciphertext.size() + EVP_CIPHER_block_size(EVP_aes_128_cbc()));
    int len;
    if (EVP_DecryptUpdate(ctx, plaintext.data(), &len, ciphertext.data(), ciphertext.size()) != 1)
    {
        std::println("\033[31mEVP_DecryptUpdate 失败！\033[0m");
        EVP_CIPHER_CTX_free(ctx);
        return false;
    }
    int plaintext_len = len;

    if (EVP_DecryptFinal_ex(ctx, plaintext.data() + len, &len) != 1)
    {
        std::println("\033[31mEVP_DecryptFinal_ex 失败！可能密钥错误或数据损坏。\033[0m");
        EVP_CIPHER_CTX_free(ctx);
        return false;
    }
    plaintext_len += len;
    plaintext.resize(plaintext_len);

    EVP_CIPHER_CTX_free(ctx);
    return true;
}

// 将解密后的数据直接写回原文件
static bool decryptFileInPlace(const fs::path &filePath, size_t current_file, size_t total_files, const std::vector<unsigned char> &key, const std::vector<unsigned char> &iv)
{
    try
    {
        std::ifstream inputFile(filePath, std::ios::binary);
        if (!inputFile)
        {
            std::println("\033[31m不能打开 {} 进行读取。\033[0m", filePath.string());
            return false;
        }

        inputFile.seekg(0, std::ios::end);
        size_t fileSize = inputFile.tellg();
        inputFile.seekg(0, std::ios::beg);

        std::vector<unsigned char> ciphertext;
        ciphertext.reserve(fileSize);

        const size_t bufferSize = 8192;
        std::vector<char> buffer(bufferSize);
        size_t totalRead = 0;

        // 记录上一次输出的长度，用于清除
        static size_t last_output_length = 0;

        while (inputFile)
        {
            inputFile.read(buffer.data(), bufferSize);
            size_t bytesRead = inputFile.gcount();
            if (bytesRead > 0)
            {
                ciphertext.insert(ciphertext.end(), buffer.begin(), buffer.begin() + bytesRead);
                totalRead += bytesRead;

                // 使用通用进度显示函数
                updateProgressDisplay("解密进度", current_file, total_files, 
                                     filePath.filename().string(), &last_output_length);
            }
        }
        inputFile.close();

        std::vector<unsigned char> plaintext;
        if (!decryptAes128Cbc(ciphertext, plaintext, key, iv))
        {
            return false;
        }

        std::ofstream outputFile(filePath, std::ios::binary | std::ios::trunc);
        if (!outputFile)
        {
            std::println("\033[31m不能打开 {} 进行写入。\033[0m", filePath.string());
            return false;
        }

        outputFile.write(reinterpret_cast<const char *>(plaintext.data()), plaintext.size());
        outputFile.close();

        return true;
    }
    catch (const std::exception &e)
    {
        std::println("\033[31m解密失败 {} 因为 {}\033[0m", filePath.string(), e.what());
        return false;
    }
}

// 解密文件
bool decryptFiles(const std::vector<fs::path> &files, const std::vector<unsigned char> &key, const std::vector<unsigned char> &iv)
{
    size_t total_files = files.size();
    size_t current_file = 0;
    static size_t last_length = 0;

    for (const auto &file : files)
    {
        current_file++;
        if (!decryptFileInPlace(file, current_file, total_files, key, iv))
        {
            return false;
        }
        updateProgressDisplay("解密进度", current_file, total_files,
                              file.filename().string(), &last_length);
    }
    // 清除最后一行进度显示
    std::cout << "\r" << std::string(last_length, ' ') << "\r";
    std::println("\033[32m数据表解密完成。\033[0m");
    return true;
}

// 检查文件是否已解密
bool isFileDecrypted(const fs::path &filePath)
{
    std::ifstream file(filePath, std::ios::binary);
    if (!file)
        return false;

    unsigned char header[32];
    file.read(reinterpret_cast<char *>(header), 32);

    if (!file)
        return false;

    bool has_uniform_offsets = false;
    for (int i = 16; i < 28; i += 4)
    {
        uint32_t curr = *reinterpret_cast<uint32_t *>(&header[i]);
        uint32_t next = *reinterpret_cast<uint32_t *>(&header[i + 4]);
        // 检查相邻的两个4字节整数是否形成递减序列
        if (curr > next && (curr - next) < 0x1000)
        {
            has_uniform_offsets = true;
            break;
        }
    }

    return has_uniform_offsets;
}

// 转换表为json
bool convertTablesToJson(const std::string &schema_dir, const std::string &table_dir, const std::string &output_dir)
{
    try
    {
        if (!fs::exists(output_dir))
        {
            fs::create_directory(output_dir);
        }

        size_t total_files = 0;
        for (const auto &entry : fs::directory_iterator(schema_dir))
        {
            if (entry.path().extension() == ".fbs")
            {
                if (fs::exists(fs::path(table_dir) / (entry.path().stem().string() + ".tbl")))
                {
                    total_files++;
                }
            }
        }

        size_t current_file = 0;
        int result = 0;
        static size_t last_length = 0;

        for (const auto &entry : fs::directory_iterator(schema_dir))
        {
            if (entry.path().extension() == ".fbs")
            {
                std::string schema_name = entry.path().stem().string();
                fs::path tbl_path = fs::path(table_dir) / (schema_name + ".tbl");

                if (fs::exists(tbl_path))
                {
                    current_file++;

                    updateProgressDisplay("转换进度", current_file, total_files,
                                          schema_name + ".tbl", &last_length);

                    std::string command = "flatc --json --raw-binary --strict-json --natural-utf8 -o " +
                                          output_dir + " " +
                                          entry.path().string() + " -- " +
                                          tbl_path.string() + " 2>/dev/null";
                    result = system(command.c_str());
                    if (result != 0)
                    {
                        continue;
                    }
                }
            }
        }

        // 清除最后一行进度显示
        std::cout << "\r" << std::string(last_length, ' ') << "\r";

        if (result == 0)
        {
            std::println("\033[32m数据表转换完成。\033[0m");
            return true;
        }
        return false;
    }
    catch (const std::exception &e)
    {
        std::println("\033[31m转换过程出错: {} \033[0m", e.what());
        return false;
    }
}

std::vector<std::string> QooAppAPI::generateVersions(const std::string &baseVersion)
{
    std::vector<std::string> versions;

    // 解析基础版本号
    std::regex version_regex(R"((\d+)\.(\d+)\.(\d+))");
    std::smatch matches;
    if (!std::regex_match(baseVersion, matches, version_regex))
    {
        return versions;
    }

    int major = std::stoi(matches[1]);
    int minor = std::stoi(matches[2]);
    int patch = std::stoi(matches[3]);

    // 当前minor版本，从当前patch开始，向上检查到200
    for (int p = patch; p <= 200; p++)
    {
        versions.push_back(std::format("{}.{}.{}", major, minor, p));
    }

    // 下一个minor版本，从1开始，向上检查到200
    for (int p = 1; p <= 200; p++)
    {
        versions.push_back(std::format("{}.{}.{}", major, minor + 1, p));
    }

    // 主版本号递增，minor从0开始，patch从0开始，向上检查到200
    for (int p = 0; p <= 200; p++)
    {
        versions.push_back(std::format("{}.{}.{}", major + 1, 0, p));
    }

    return versions;
}

bool QooAppAPI::checkVersion(const std::string &version, std::string &cdnDate)
{
    std::string url = "https://gc-infodesk-zinny3.kakaogames.com/v2/app?appId=743491&appVer=" +
                      version + "&market=googlePlay&sdkVer=1&os=android&lang=en";
    try
    {
        std::string response = httpGet(url);
        if (response.empty())
        {
            return false;
        }

        json data;
        try
        {
            data = json::parse(response);
        }
        catch (const json::parse_error &e)
        {

            return false;
        }

        // 检查是否是review版本
        if (data.contains("content") &&
            data["content"].contains("appOption") &&
            data["content"]["appOption"].contains("appVerSvcStatus") &&
            data["content"]["appOption"]["appVerSvcStatus"] == "review")
        {
            // 确保cdnAddr存在且不为null
            if (data["content"]["appOption"].contains("cdnAddr") &&
                !data["content"]["appOption"]["cdnAddr"].is_null())
            {
                std::string cdnAddr = data["content"]["appOption"]["cdnAddr"];
                std::regex date_regex(R"(/Review/(\d{4}))");
                std::smatch matches;
                if (std::regex_search(cdnAddr, matches, date_regex))
                {
                    cdnDate = matches[1];
                    return true;
                }
            }
        }
    }
    catch (const std::exception &e)
    {
        return false;
    }
    catch (...)
    {
        return false;
    }

    return false;
}

QooAppAPI::ReviewServerInfo QooAppAPI::checkReviewServer(const std::string &baseVersion)
{
    ReviewServerInfo info;
    info.exists = false;
    info.version = "";
    info.cdnDate = "";
    info.tableInfo.version = 0;
    info.tableInfo.action = 0;

    // 首先搜索新版本
    std::vector<std::string> versions = generateVersions(baseVersion);

    // 获取CPU核心数，如果获取失败则使用默认值8
    const unsigned int cpu_cores = std::thread::hardware_concurrency();
    // 将线程数设置为核心数的18倍，但不超过1024
    const int max_threads = std::min(static_cast<unsigned int>(1024),
                                     cpu_cores > 0 ? cpu_cores * 18 : 128);

    std::vector<std::future<std::pair<bool, std::string>>> futures;
    std::vector<std::string> pending_versions;
    size_t total_versions = versions.size();
    size_t checked_versions = 0;
    static size_t last_output_length = 0;
    bool found_version = false;

    for (const auto &ver : versions)
    {
        if (found_version)
            break;

        // 当达到最大线程数时处理结果
        if (futures.size() >= max_threads)
        {
            // 处理当前批次的futures
            for (size_t i = 0; i < futures.size(); i++)
            {
                auto result = futures[i].get();
                checked_versions++;

                if (result.first)
                {
                    info.exists = true;
                    info.version = pending_versions[i];
                    info.cdnDate = result.second;
                    found_version = true;
                    break;
                }

                // 更新进度显示
                updateProgressDisplay("检查进度", checked_versions, total_versions, ver, &last_output_length);
            }
            // 清除最后一行进度显示
            std::cout << "\r" << std::string(last_output_length, ' ') << "\r";

            futures.clear();
            pending_versions.clear();
            if (found_version)
                break;
        }

        futures.push_back(std::async(std::launch::async, [ver]()
                                     {
            std::string cdnDate;
            bool success = checkVersion(ver, cdnDate);
            return std::make_pair(success, cdnDate); }));
        pending_versions.push_back(ver);
    }

    // 处理剩余的futures
    for (size_t i = 0; i < futures.size(); i++)
    {
        auto result = futures[i].get();
        checked_versions++;

        if (result.first)
        {
            info.exists = true;
            info.version = pending_versions[i];
            info.cdnDate = result.second;
            found_version = true;
            break;
        }

        // 更新进度显示
        updateProgressDisplay("检查进度", checked_versions, total_versions,
                              "当前版本: " + pending_versions[i], &last_output_length);
    }
    // 清除最后一行进度显示
    std::cout << "\r" << std::string(last_output_length, ' ') << "\r";

    // 确保显示100%进度
    if (!found_version && checked_versions < total_versions)
    {
        checked_versions = total_versions;
        updateProgressDisplay("检查进度", checked_versions, total_versions, versions.back(), &last_output_length);
    }
    // 清除最后一行进度显示
    std::cout << "\r" << std::string(last_output_length, ' ') << "\r";

    // 如果没有找到新版本,再检查 table_info.json 中的版本
    if (!info.exists)
    {
        fs::path table_info_path = "../table_info.json";
        if (fs::exists(table_info_path))
        {
            try
            {
                std::ifstream file(table_info_path);
                json table_info = json::parse(file);

                if (table_info.contains("review") &&
                    table_info["review"].contains("version") &&
                    !table_info["review"]["version"].is_null() &&
                    table_info["review"].contains("cdnDate") &&
                    !table_info["review"]["cdnDate"].is_null() &&
                    table_info["review"].contains("tableVersion") &&
                    !table_info["review"]["tableVersion"].is_null())
                {

                    info.exists = true;
                    info.version = table_info["review"]["version"].get<std::string>();
                    info.cdnDate = table_info["review"]["cdnDate"].get<std::string>();
                    info.tableInfo.version = table_info["review"]["tableVersion"].get<int>();

                    // 验证这个版本是否可访问
                    std::string url = std::format(
                        "https://patch.esoul.kakaogames.com/Review/{}/{}/Table/const_data_version.json",
                        info.cdnDate, info.version);

                    std::string response = httpGet(url);
                    if (!response.empty())
                    {
                        try
                        {
                            json data = json::parse(response);
                            info.tableInfo.action = data["action"].get<int>();
                        }
                        catch (...)
                        {
                        }
                    }
                    else
                    {
                    }
                }
            }
            catch (const json::exception &e)
            {
                std::println("\033[33mJSON解析错误: {}\033[0m", e.what());
            }
        }
    }

    if (!info.exists)
    {
        std::println("\033[33m未找到可用的 Review 服务器版本\033[0m");
    }

    return info;
}

bool QooAppAPI::downloadAndProcessReviewTables(const ReviewServerInfo &reviewInfo)
{
    std::println("检查 Review 服务器数据表更新...");

    // 获取服务器上的实际版本信息
    std::string versionUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Table/const_data_version.json",
                                         reviewInfo.cdnDate, reviewInfo.version);
    std::println("检查版本URL: {}", versionUrl);

    std::string versionResponse = httpGet(versionUrl);
    if (versionResponse.empty())
    {
        std::println("\033[31m获取 Review 服务器版本信息失败\033[0m");
        return false;
    }

    json versionData = json::parse(versionResponse);
    int serverTableVersion = versionData["version"].get<int>();
    std::println("服务器数据表版本: {}", serverTableVersion);

    std::string hashUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Android/catalog_eversoul.hash",
                                      reviewInfo.cdnDate, reviewInfo.version);
    std::println("检查哈希URL: {}", hashUrl);
    std::string currentHash = httpGet(hashUrl);
    std::println("服务器哈希值: {}", currentHash);

    fs::path table_info_path = "../table_info.json";
    json table_info;
    bool needUpdate = true;

    // 检查 Review 服务器数据表文件夹是否存在
    bool reviewTablesExist = fs::exists("../review_tables") && !fs::is_empty("../review_tables");
    std::println("Review 数据表目录存在且非空: {}", reviewTablesExist ? "是" : "否");

    if (fs::exists(table_info_path))
    {
        std::println("检查 table_info.json...");
        std::ifstream file(table_info_path);
        table_info = json::parse(file);

        if (table_info.contains("review"))
        {
            std::println("当前保存的信息:");
            std::println("版本: {}", table_info["review"]["version"].get<std::string>());
            // std::println("日期: {}", table_info["review"]["cdnDate"].get<std::string>());
            std::println("表版本: {}", table_info["review"]["tableVersion"].get<int>());
            std::println("哈希值: {}", table_info["review"]["hash"].get<std::string>());
        }

        // 比较版本号和哈希值
        if (table_info.contains("review") &&
            table_info["review"]["version"] == reviewInfo.version &&
            table_info["review"]["cdnDate"] == reviewInfo.cdnDate &&
            table_info["review"]["tableVersion"] == serverTableVersion &&
            table_info["review"]["hash"] == currentHash &&
            reviewTablesExist)
        {
            std::println("\033[32mReview 服务器数据表已是最新版本\033[0m");
            return false;
        }
        else
        {
            std::println("需要更新数据表:");
            if (table_info.contains("review"))
            {
                if (table_info["review"]["tableVersion"] != serverTableVersion)
                    std::println("- 表版本不同: {} -> {}",
                                 table_info["review"]["tableVersion"].get<int>(), serverTableVersion);
                if (table_info["review"]["hash"] != currentHash)
                    std::println("- 哈希值不同");
            }
            else
            {
                std::println("- table_info.json 中没有 review 信息");
            }
        }
    }
    else
    {
        std::println("table_info.json 不存在，将创建新文件");
    }

    // 构建下载链接
    std::string zipUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Table/data_{}.zip",
                                     reviewInfo.cdnDate, reviewInfo.version, serverTableVersion);
    std::println("下载URL: {}", zipUrl);
    std::string zipPath = "../review_data_" + std::to_string(serverTableVersion) + ".zip";

    // 添加下载重试逻辑
    const int maxRetries = 3;
    bool downloadSuccess = false;
    
    for (int retry = 1; retry <= maxRetries; retry++) {
        if (downloadFile(zipUrl, zipPath)) {
            downloadSuccess = true;
            break;
        }
        
        std::println("\033[33m下载失败，等待重试...\033[0m");
        // 重试前等待一段时间，避免频繁请求
        std::this_thread::sleep_for(std::chrono::seconds(2));
    }
    
    if (!downloadSuccess) {
        std::println("\033[31m下载 Review 数据表压缩包失败，已重试 {} 次\033[0m", maxRetries);
        return false;
    }

    if (!fs::exists("../review_tables"))
    {
        fs::create_directory("../review_tables");
    }
    std::string unzipCommand = "unzip -o " + zipPath + " -d ../review_tables/ > /dev/null 2>&1";
    system(unzipCommand.c_str());

    fs::remove(zipPath);

    // 解密 Review 数据表
    std::vector<unsigned char> key, iv;
    if (!deriveKeyAndIv(key, iv))
    {
        std::println("\033[31m密钥派生失败\033[0m");
        return false;
    }

    std::vector<fs::path> files_to_decrypt;
    for (const auto &entry : fs::directory_iterator("../review_tables"))
    {
        if (entry.is_regular_file() && !isFileDecrypted(entry.path()))
        {
            files_to_decrypt.push_back(entry.path());
        }
    }

    if (!decryptFiles(files_to_decrypt, key, iv))
    {
        std::println("\033[31mReview 数据表解密失败\033[0m");
        return false;
    }

    // 转换 Review 数据表
    if (!fs::exists("../review_jsons"))
    {
        fs::create_directory("../review_jsons");
    }
    if (!convertTablesToJson("../schemas", "../review_tables", "../review_jsons"))
    {
        std::println("\033[31mReview 数据表转换失败\033[0m");
        return false;
    }

    // 更新 table_info.json
    table_info["review"] = {
        {"version", reviewInfo.version},
        {"cdnDate", reviewInfo.cdnDate},
        {"tableVersion", serverTableVersion},
        {"hash", currentHash}};

    std::ofstream outFile(table_info_path);
    outFile << table_info.dump(4);

    std::println("\033[32mReview 服务器数据表已更新到最新版本\033[0m");
    return true;
}

// 检查并安装必要的Python库
bool QooAppAPI::checkAndInstallPythonLibraries()
{
    // 检查python3是否可用
    int pythonCheck = system("python --version > /dev/null 2>&1");
    if (pythonCheck != 0)
    {
        std::println("\033[31mPython3未安装或不可用\033[0m");
        return false;
    }
    
    // 检查google_play_scraper库是否已安装
    std::string checkScript = R"(import importlib.util
import sys
print("installed" if importlib.util.find_spec("google_play_scraper") else "not_installed")
)";
    
    // 检查脚本文件是否存在，不存在则创建
    if (!fs::exists("check_library.py"))
    {
        std::ofstream scriptFile("check_library.py");
        scriptFile << checkScript;
        scriptFile.close();
    }
    
    FILE* pipe = popen("python check_library.py", "r");
    if (!pipe)
    {
        return false;
    }
    
    char buffer[128];
    std::string result = "";
    while (!feof(pipe))
    {
        if (fgets(buffer, 128, pipe) != nullptr)
            result += buffer;
    }
    pclose(pipe);
    
    // 去除结果中的空白字符
    result.erase(std::remove_if(result.begin(), result.end(), ::isspace), result.end());
    
    if (result == "not_installed")
    {
        std::println("安装 google_play_scraper 库...");
        int installResult = system("pip install google_play_scraper --user > /dev/null 2>&1");
        if (installResult != 0)
        {
            std::println("\033[31m安装 google_play_scraper 失败\033[0m");
            return false;
        }
        std::println("\033[32m成功安装 google_play_scraper\033[0m");
    }
    
    return true;
}

// 使用Python脚本获取应用版本号
std::string QooAppAPI::getVersionWithPython()
{

    std::string pythonScript = R"(import json
from google_play_scraper import app as playstore_app

try:
    result = playstore_app(app_id="com.kakaogames.eversoul", lang="en", country="kr")
    print(json.dumps({"success": True, "version": result["version"]}))
except Exception as e:
    print(json.dumps({"success": False, "error": str(e)}))
)";
    
    // 不存在则创建
    if (!fs::exists("version_scraper.py"))
    {
        std::ofstream scriptFile("version_scraper.py");
        scriptFile << pythonScript;
        scriptFile.close();
    }
    
    std::string command = "python version_scraper.py 2>/dev/null";
    FILE* pipe = popen(command.c_str(), "r");
    if (!pipe)
    {
        std::println("\033[31mPython脚本执行失败\033[0m");
        return "";
    }
    
    char buffer[128];
    std::string result = "";
    while (!feof(pipe))
    {
        if (fgets(buffer, 128, pipe) != nullptr)
            result += buffer;
    }
    pclose(pipe);
    
    try
    {
        json response = json::parse(result);
        if (response["success"])
        {
            return response["version"];
        }
        else
        {
            std::println("\033[33mPython获取版本号失败: {}\033[0m", response["error"].get<std::string>());
        }
    }
    catch (const std::exception& e)
    {
        std::println("\033[31mPython脚本返回结果解析失败: {}\033[0m", e.what());
    }
    
    return "";
}
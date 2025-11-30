#include "table_updater.hpp"
#include "version_manager.hpp"

namespace TableUpdater
{
    // 前向声明
    int getServerTableVersion(const ReviewServerInfo &reviewInfo);

    TableInfo getTableInfo(const std::string &version)
    {
        std::string url = "https://patch.esoul.kakaogames.com/Live/" + version + "/Table/const_data_version.json";
        std::string response = HttpClient::get(url);

        json data = json::parse(response);
        TableInfo info;
        info.version = data["version"];
        info.action = data["action"];
        return info;
    }

    bool updateDataTables(ServerType type, const std::string &version, const ReviewServerInfo *reviewInfo)
    {
        // 1. 准备阶段：获取版本信息、下载链接、目标路径等
        std::string zipUrl;
        int tableVersion = 0;
        std::string currentVersion = version;
        std::string serverRegion;
        std::string tableType; // "Live" or "Review"
        fs::path targetDir;
        fs::path schemaDir;
        int cdnDate = 0; // Only for Review

        switch (type)
        {
        case ServerType::GlobalLive:
        {
            serverRegion = "Global";
            tableType = "Live";
            targetDir = "../Table/Global/Live";
            schemaDir = "../FlatBuffers/Schema/Global";

        // 获取服务器上的实际版本信息
            std::string versionUrl = std::format("https://patch.esoul.kakaogames.com/Live/{}/Table/const_data_version.json", currentVersion);
        std::println("检查版本URL: {}", versionUrl);

            TableInfo info = getTableInfo(currentVersion);
            if (info.version == 0)
        {
            std::println("\033[31m获取数据表信息失败\033[0m");
            return false;
        }
            tableVersion = info.version;
            std::println("服务器数据表版本: {}", tableVersion);

            zipUrl = std::format("https://patch.esoul.kakaogames.com/Live/{}/Table/data_{}.zip", currentVersion, tableVersion);
            break;
        }
        case ServerType::CnLive:
        {
            serverRegion = "Cn";
            tableType = "Live";
            targetDir = "../Table/Cn/Live";
            schemaDir = "../FlatBuffers/Schema/Global";

            // 获取国服配置
            auto cnConfig = VersionManager::getCnServerConfig();
            if (!cnConfig.isValid)
            {
                std::println("\033[31m获取国服配置失败\033[0m");
                return false;
            }
            currentVersion = cnConfig.version;

            // 尝试从每个URL获取数据表版本信息
            std::string workingBaseUrl;
            for (const auto &baseUrl : cnConfig.downloadUrls)
            {
                try
                {
                    std::string versionUrl = std::format("{}/{}/Table/const_data_version.json", baseUrl, currentVersion);
                    std::println("检查版本URL: {}", versionUrl);

                    std::string response = HttpClient::get(versionUrl);
                    if (!response.empty())
                    {
                        json data = json::parse(response);
                        tableVersion = data["version"];
                        workingBaseUrl = baseUrl;
                        std::println("服务器数据表版本: {}", tableVersion);
                        break;
                    }
                }
                catch (...)
                {
                    continue;
                }
            }

            if (tableVersion == 0 || workingBaseUrl.empty())
            {
                std::println("\033[31m所有URL都无法获取数据表信息\033[0m");
                return false;
            }

            zipUrl = std::format("{}/{}/Table/data_{}.zip", workingBaseUrl, currentVersion, tableVersion);
            break;
        }
        case ServerType::GlobalReview:
        {
            serverRegion = "Global";
            tableType = "Review";
            targetDir = "../Table/Global/Review";
            schemaDir = "../FlatBuffers/Schema/Global";

            // 如果没有提供 reviewInfo，则自动检查
            ReviewServerInfo localReviewInfo;
            if (!reviewInfo)
            {
                if (version.empty())
                {
                    std::println("\033[31mGlobalReview 需要提供 baseVersion 或 reviewInfo\033[0m");
                    return false;
                }
                localReviewInfo = checkReviewServer(version, serverRegion);
                if (!localReviewInfo.exists)
                {
                    std::println("\033[33m未找到可用的 Review 服务器版本\033[0m");
                    return false;
                }
                reviewInfo = &localReviewInfo;
            }

            currentVersion = reviewInfo->version;
            cdnDate = reviewInfo->cdnDate;

            tableVersion = getServerTableVersion(*reviewInfo);
            if (tableVersion == -1)
                return false;

            zipUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Table/data_{}.zip",
                                 cdnDate, currentVersion, tableVersion);
            break;
        }
        }

        // 2. 检查本地信息，是否需要更新
        fs::path table_info_path = "./table_info.json";
        json table_info;
        bool tableExist = fs::exists(targetDir) && !fs::is_empty(targetDir);

        if (fs::exists(table_info_path))
        {
            try
        {
            std::ifstream file(table_info_path);
            table_info = json::parse(file);

                if (table_info.contains(serverRegion) &&
                    table_info[serverRegion].contains(tableType) &&
                    table_info[serverRegion][tableType]["version"] == currentVersion &&
                    table_info[serverRegion][tableType]["tableVersion"] == tableVersion &&
                    tableExist)
                {
                    if (type == ServerType::GlobalReview &&
                        table_info[serverRegion][tableType].contains("cdnDate") &&
                        table_info[serverRegion][tableType]["cdnDate"].get<int>() != cdnDate)
            {
                        // Continue update if cdnDate mismatch for Review
            }
            else
                    {
                        std::println("\033[32m{} {} 数据表已是最新版本\033[0m", serverRegion, tableType);
                        return false;
                    }
                }
                else
                {
                    // Just log/print reason if needed
                    if (table_info.contains(serverRegion) && table_info[serverRegion].contains(tableType))
                    {
                        if (table_info[serverRegion][tableType]["tableVersion"] != tableVersion)
                        {
                            std::println("表版本不同: {} -> {}",
                                         table_info[serverRegion][tableType]["tableVersion"].get<int>(), tableVersion);
                }
                    }
                }
            }
            catch (...)
            {
            }
        }
        else
        {
            std::println("table_info.json 不存在，将创建新文件");
        }

        // 3. 下载
        std::string zipPath = "../data_" + serverRegion + "_" + tableType + "_" + std::to_string(tableVersion) + ".zip";
        if (!FileDownloader::downloadWithRetry(zipUrl, zipPath, 3, true))
        {
            return false;
        }

        // 4. 清理旧目录并解压
        if (fs::exists(targetDir))
        {
            fs::remove_all(targetDir);
        }
        fs::create_directories(targetDir);

        std::string unzipCommand = "unzip -o " + zipPath + " -d " + targetDir.string() + "/ > /dev/null 2>&1";
        system(unzipCommand.c_str());
        fs::remove(zipPath);

        // 5. 解密
        std::vector<uint8_t> key, iv;
        if (!CryptoUtils::deriveKeyAndIv(key, iv))
        {
            std::println("\033[31m密钥派生失败\033[0m");
            return false;
        }

        std::vector<fs::path> files_to_decrypt;
        for (const auto &entry : fs::directory_iterator(targetDir))
        {
            if (entry.is_regular_file() && !CryptoUtils::isFileDecrypted(entry.path()))
            {
                files_to_decrypt.push_back(entry.path());
            }
        }

        if (!CryptoUtils::decryptFiles(files_to_decrypt, key, iv))
        {
            std::println("\033[31m数据表解密失败\033[0m");
            return false;
        }

        // 6. 转换
        if (!TableConverter::convertTablesToJson(schemaDir.string(), targetDir.string(), targetDir.string()))
        {
            std::println("\033[31m数据表转换失败\033[0m");
            return false;
        }

        // 7. 清理 .tbl
        for (const auto &entry : fs::directory_iterator(targetDir))
        {
            if (entry.is_regular_file() && entry.path().extension() == ".tbl")
            {
                fs::remove(entry.path());
            }
        }

        // 8. 更新 JSON
        try
        {
            if (!table_info.contains(serverRegion))
            {
                table_info[serverRegion] = json::object();
            }

            table_info[serverRegion][tableType] = {
                {"version", currentVersion},
                {"tableVersion", tableVersion}};

            if (type == ServerType::GlobalReview && cdnDate > 0)
            {
                table_info[serverRegion][tableType]["cdnDate"] = cdnDate;
            }

        std::ofstream outFile(table_info_path);
        outFile << table_info.dump(4);
        }
        catch (...)
        {
        }

        std::println("\033[32m{} {} 数据表已更新到最新版本\033[0m", serverRegion, tableType);
        return true;
    }

    bool checkReviewVersion(const std::string &version, int &cdnDate)
    {
        std::string url = "https://gc-infodesk-zinny3.kakaogames.com/v2/app?appId=743491&appVer=" +
                          version + "&market=googlePlay&sdkVer=1&os=android&lang=en";
        try
        {
            std::string response = HttpClient::get(url);
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
                        cdnDate = std::stoi(matches[1].str());
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

    ReviewServerInfo checkReviewServer(const std::string &baseVersion, const std::string &serverRegion)
    {
        ReviewServerInfo info;
        info.exists = false;
        info.version = "";
        info.cdnDate = 0;
        info.tableInfo.version = 0;
        info.tableInfo.action = 0;

        // 首先搜索新版本
        std::vector<std::string> versions = VersionManager::generatePossibleVersions(baseVersion);

        // 获取CPU核心数，如果获取失败则使用默认值128
        const uint32_t cpu_cores = std::thread::hardware_concurrency();
        // 将线程数设置为核心数的18倍，但不超过1024
        const int max_threads = std::min(static_cast<uint32_t>(1024),
                                         cpu_cores > 0 ? cpu_cores * 18 : 128);

        std::vector<std::future<std::pair<bool, int>>> futures;
        std::vector<std::string> pending_versions;
        size_t total_versions = versions.size();
        size_t checked_versions = 0;
        static size_t last_output_length = 0;
        bool found_version = false;

        for (const auto &ver : versions)
        {
            if (found_version)
                break;
            if (futures.size() >= max_threads)
            {
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
                    ProgressDisplay::update("检查进度", checked_versions, total_versions, ver, &last_output_length);
                }

                futures.clear();
                pending_versions.clear();
                if (found_version)
                    break;
            }

            futures.push_back(std::async(std::launch::async, [ver]()
                                         {
                int cdnDate = 0;
                bool success = checkReviewVersion(ver, cdnDate);
                return std::make_pair(success, cdnDate); }));
            pending_versions.push_back(ver);
        }

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

            ProgressDisplay::update("检查进度", checked_versions, total_versions, pending_versions[i], &last_output_length);
        }

        if (!found_version && checked_versions < total_versions)
        {
            checked_versions = total_versions;
            ProgressDisplay::update("检查进度", checked_versions, total_versions, versions.back(), &last_output_length);
        }
        ProgressDisplay::clear(last_output_length);

        if (!info.exists)
        {
            fs::path table_info_path = "./table_info.json";
            if (fs::exists(table_info_path))
            {
                try
                {
                    std::ifstream file(table_info_path);
                    json table_info = json::parse(file);

                    if (table_info.contains(serverRegion) &&
                        table_info[serverRegion].contains("Review") &&
                        table_info[serverRegion]["Review"].contains("version") &&
                        !table_info[serverRegion]["Review"]["version"].is_null() &&
                        table_info[serverRegion]["Review"].contains("cdnDate") &&
                        !table_info[serverRegion]["Review"]["cdnDate"].is_null() &&
                        table_info[serverRegion]["Review"].contains("tableVersion") &&
                        !table_info[serverRegion]["Review"]["tableVersion"].is_null())
                    {

                        info.exists = true;
                        info.version = table_info[serverRegion]["Review"]["version"].get<std::string>();
                        info.cdnDate = table_info[serverRegion]["Review"]["cdnDate"].get<int>();
                        info.tableInfo.version = table_info[serverRegion]["Review"]["tableVersion"].get<int>();

                        // 验证这个版本是否可访问
                        std::string url = std::format(
                            "https://patch.esoul.kakaogames.com/Review/{}/{}/Table/const_data_version.json",
                            info.cdnDate, info.version);

                        std::string response = HttpClient::get(url);
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

    /**
     * @brief 获取服务器数据表版本信息
     * @param reviewInfo Review服务器信息
     * @return 服务器数据表版本号，失败时返回-1
     */
    int getServerTableVersion(const ReviewServerInfo &reviewInfo)
    {
        std::string versionUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Table/const_data_version.json",
                                             reviewInfo.cdnDate, reviewInfo.version);
        std::println("检查版本URL: {}", versionUrl);

        std::string versionResponse = HttpClient::get(versionUrl);
        if (versionResponse.empty())
        {
            std::println("\033[31m获取 Review 服务器版本信息失败\033[0m");
            return -1;
        }

        try
        {
            json versionData = json::parse(versionResponse);
            int serverVersion = versionData["version"].get<int>();
            std::println("服务器数据表版本: {}", serverVersion);
            return serverVersion;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m解析版本信息失败: {}\033[0m", e.what());
            return -1;
        }
    }

    /**
     * @brief 检查是否需要更新Review数据表
     * @param reviewInfo Review服务器信息
     * @param serverTableVersion 服务器数据表版本
     * @param serverRegion 服务器区域
     * @return 需要更新返回true，否则返回false
     */
    bool needUpdateReviewTables(const ReviewServerInfo &reviewInfo, int serverTableVersion, const std::string &serverRegion)
    {
        fs::path table_info_path = "./table_info.json";

        bool reviewTableExist = fs::exists("../Table/Global/Review") && !fs::is_empty("../Table/Global/Review");
        // std::println("Review 数据表目录存在且非空: {}", reviewTableExist ? "是" : "否");

        if (!fs::exists(table_info_path))
        {
            std::println("table_info.json 不存在，需要下载数据表");
            return true;
        }

        try
        {
            std::ifstream file(table_info_path);
            json table_info = json::parse(file);

            if (table_info.contains(serverRegion) && table_info[serverRegion].contains("Review"))
            {
                // std::println("当前保存的信息:");
                // std::println("版本: {}", table_info[serverRegion]["review"]["version"].get<std::string>());
                // std::println("表版本: {}", table_info[serverRegion]["review"]["tableVersion"].get<int>());

                if (table_info[serverRegion]["Review"]["version"] == reviewInfo.version &&
                    table_info[serverRegion]["Review"]["cdnDate"] == reviewInfo.cdnDate &&
                    table_info[serverRegion]["Review"]["tableVersion"] == serverTableVersion &&
                    reviewTableExist)
                {
                    std::println("\033[32mReview 服务器数据表已是最新版本\033[0m");
                    return false;
                }

                if (table_info[serverRegion]["Review"]["tableVersion"] != serverTableVersion)
                {
                    std::println("表版本不同: {} -> {}",
                                 table_info[serverRegion]["Review"]["tableVersion"].get<int>(), serverTableVersion);
                }
            }
            else
            {
                std::println("- table_info.json 中没有 {} review 信息", serverRegion);
            }
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m解析table_info.json失败: {}\033[0m", e.what());
        }

        return true;
    }

    /**
     * @brief 下载并解压Review数据表
     * @param reviewInfo Review服务器信息
     * @param serverTableVersion 服务器数据表版本
     * @return 成功返回true，失败返回false
     */
    bool downloadReviewTables(const ReviewServerInfo &reviewInfo, int serverTableVersion)
    {
        // 构建下载链接
        std::string zipUrl = std::format("https://patch.esoul.kakaogames.com/Review/{}/{}/Table/data_{}.zip",
                                         reviewInfo.cdnDate, reviewInfo.version, serverTableVersion);
        // std::println("下载URL: {}", zipUrl);
        std::string zipPath = "../review_data_" + std::to_string(serverTableVersion) + ".zip";

        // 下载数据表压缩包（智能多线程下载）
        if (!FileDownloader::downloadWithRetry(zipUrl, zipPath, 3, true))
        {
            return false;
        }

        fs::create_directories("../Table/Global/Review");

        std::string unzipCommand = "unzip -o " + zipPath + " -d ../Table/Global/Review/ > /dev/null 2>&1";
        int result = system(unzipCommand.c_str());
        fs::remove(zipPath);

        if (result != 0)
        {
            std::println("\033[31m解压失败\033[0m");
            return false;
        }

        return true;
    }

    /**
     * @brief 解密Review数据表文件
     * @return 成功返回true，失败返回false
     */
    bool decryptReviewTables()
    {
        std::vector<uint8_t> key, iv;
        if (!CryptoUtils::deriveKeyAndIv(key, iv))
        {
            std::println("\033[31m密钥派生失败\033[0m");
            return false;
        }

        std::vector<fs::path> files_to_decrypt;
        for (const auto &entry : fs::directory_iterator("../Table/Global/Review"))
        {
            if (entry.is_regular_file() && !CryptoUtils::isFileDecrypted(entry.path()))
            {
                files_to_decrypt.push_back(entry.path());
            }
        }

        if (!files_to_decrypt.empty())
        {
            if (!CryptoUtils::decryptFiles(files_to_decrypt, key, iv))
            {
                std::println("\033[31mReview 数据表解密失败\033[0m");
                return false;
            }
        }

        return true;
    }

    /**
     * @brief 转换Review数据表为JSON格式
     * @return 成功返回true，失败返回false
     */
    bool convertReviewTablesToJson()
    {
        if (!TableConverter::convertTablesToJson("../FlatBuffers/Schema/Global", "../Table/Global/Review", "../Table/Global/Review"))
        {
            std::println("\033[31mReview 数据表转换失败\033[0m");
            return false;
        }

        for (const auto &entry : fs::directory_iterator("../Table/Global/Review"))
        {
            if (entry.is_regular_file() && entry.path().extension() == ".tbl")
            {
                fs::remove(entry.path());
            }
        }

        return true;
    }

    /**
     * @brief 更新table_info.json文件
     * @param reviewInfo Review服务器信息
     * @param serverTableVersion 服务器数据表版本
     * @param serverRegion 服务器区域
     * @return 成功返回true，失败返回false
     */
    bool updateTableInfoFile(const ReviewServerInfo &reviewInfo, int serverTableVersion, const std::string &serverRegion)
    {
        try
        {
            fs::path table_info_path = "./table_info.json";
            json table_info;

            if (fs::exists(table_info_path))
            {
                std::ifstream file(table_info_path);
                table_info = json::parse(file);
            }

            // 确保服务器区域节点存在
            if (!table_info.contains(serverRegion))
            {
                table_info[serverRegion] = json::object();
            }

            table_info[serverRegion]["Review"] = {
                {"version", reviewInfo.version},
                {"cdnDate", reviewInfo.cdnDate},
                {"tableVersion", serverTableVersion}};

            std::ofstream outFile(table_info_path);
            outFile << table_info.dump(4);

            return true;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m更新table_info.json失败: {}\033[0m", e.what());
            return false;
        }
    }
}
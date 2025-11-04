#include "table_updater.hpp"
#include "version_manager.hpp"

namespace TableUpdater
{
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

    bool checkAndUpdateLiveTables(const std::string &version)
    {

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

        fs::path table_info_path = "./table_info.json";
        json table_info;

        // 检查正式服数据表文件夹是否存在
        bool liveTableExist = fs::exists("../live_table") && !fs::is_empty("../live_table");
        // std::println("Live 数据表目录存在且非空: {}", liveTableExist ? "是" : "否");

        if (fs::exists(table_info_path))
        {
            std::ifstream file(table_info_path);
            table_info = json::parse(file);

            // if (table_info.contains("live"))
            // {
            //     std::println("当前保存的信息:");
            //     std::println("版本: {}", table_info["live"]["version"].get<std::string>());
            //     std::println("表版本: {}", table_info["live"]["tableVersion"].get<int>());
            // }

            // 比较版本号和哈希值
            if (table_info.contains("live") &&
                table_info["live"]["version"] == version &&
                table_info["live"]["tableVersion"] == tableInfo.version &&
                liveTableExist)
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
                    {
                        std::println("表版本不同: {} -> {}",
                                     table_info["live"]["tableVersion"].get<int>(), tableInfo.version);
                    }
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
        // std::println("下载URL: {}", zipUrl);
        std::string zipPath = "../data_" + std::to_string(tableInfo.version) + ".zip";

        // 下载数据表压缩包（智能多线程下载）
        if (!FileDownloader::downloadWithRetry(zipUrl, zipPath, 3, true))
        {
            return false;
        }

        if (!fs::exists("../live_table"))
        {
            fs::create_directory("../live_table");
        }
        std::string unzipCommand = "unzip -o " + zipPath + " -d ../live_table/ > /dev/null 2>&1";
        system(unzipCommand.c_str());

        fs::remove(zipPath);

        // 解密正式服数据表
        std::vector<uint8_t> key, iv;
        if (!CryptoUtils::deriveKeyAndIv(key, iv))
        {
            std::println("\033[31m密钥派生失败\033[0m");
            return false;
        }

        std::vector<fs::path> files_to_decrypt;
        for (const auto &entry : fs::directory_iterator("../live_table"))
        {
            if (entry.is_regular_file() && !CryptoUtils::isFileDecrypted(entry.path()))
            {
                files_to_decrypt.push_back(entry.path());
            }
        }

        if (!CryptoUtils::decryptFiles(files_to_decrypt, key, iv))
        {
            std::println("\033[31m正式服数据表解密失败\033[0m");
            return false;
        }

        // 转换正式服数据表
        if (!fs::exists("../live_json"))
        {
            fs::create_directory("../live_json");
        }
        if (!TableConverter::convertTablesToJson("../schema", "../live_table", "../live_json"))
        {
            std::println("\033[31m正式服数据表转换失败\033[0m");
            return false;
        }

        table_info["live"] = {
            {"version", version},
            {"tableVersion", tableInfo.version}};

        std::ofstream outFile(table_info_path);
        outFile << table_info.dump(4);

        std::println("\033[32mLive 服务器数据表已更新到最新版本\033[0m");
        return true;
    }

    bool checkReviewVersion(const std::string &version, std::string &cdnDate)
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

    ReviewServerInfo checkReviewServer(const std::string &baseVersion)
    {
        ReviewServerInfo info;
        info.exists = false;
        info.version = "";
        info.cdnDate = "";
        info.tableInfo.version = 0;
        info.tableInfo.action = 0;

        // 首先搜索新版本
        std::vector<std::string> versions = VersionManager::generatePossibleVersions(baseVersion);

        // 获取CPU核心数，如果获取失败则使用默认值128
        const uint32_t cpu_cores = std::thread::hardware_concurrency();
        // 将线程数设置为核心数的18倍，但不超过1024
        const int max_threads = std::min(static_cast<uint32_t>(1024),
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
                std::string cdnDate;
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
     * @return 需要更新返回true，否则返回false
     */
    bool needUpdateReviewTables(const ReviewServerInfo &reviewInfo, int serverTableVersion)
    {
        fs::path table_info_path = "./table_info.json";

        bool reviewTableExist = fs::exists("../review_table") && !fs::is_empty("../review_table");
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

            if (table_info.contains("review"))
            {
                // std::println("当前保存的信息:");
                // std::println("版本: {}", table_info["review"]["version"].get<std::string>());
                // std::println("表版本: {}", table_info["review"]["tableVersion"].get<int>());

                if (table_info["review"]["version"] == reviewInfo.version &&
                    table_info["review"]["cdnDate"] == reviewInfo.cdnDate &&
                    table_info["review"]["tableVersion"] == serverTableVersion &&
                    reviewTableExist)
                {
                    std::println("\033[32mReview 服务器数据表已是最新版本\033[0m");
                    return false;
                }

                std::println("需要更新数据表:");
                if (table_info["review"]["tableVersion"] != serverTableVersion)
                {
                    std::println("表版本不同: {} -> {}",
                                 table_info["review"]["tableVersion"].get<int>(), serverTableVersion);
                }
            }
            else
            {
                std::println("- table_info.json 中没有 review 信息");
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

        // 创建目录并解压
        if (!fs::exists("../review_table"))
        {
            fs::create_directory("../review_table");
        }

        std::string unzipCommand = "unzip -o " + zipPath + " -d ../review_table/ > /dev/null 2>&1";
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
        for (const auto &entry : fs::directory_iterator("../review_table"))
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
        if (!fs::exists("../review_json"))
        {
            fs::create_directory("../review_json");
        }

        if (!TableConverter::convertTablesToJson("../schema", "../review_table", "../review_json"))
        {
            std::println("\033[31mReview 数据表转换失败\033[0m");
            return false;
        }

        return true;
    }

    /**
     * @brief 更新table_info.json文件
     * @param reviewInfo Review服务器信息
     * @param serverTableVersion 服务器数据表版本
     * @return 成功返回true，失败返回false
     */
    bool updateTableInfoFile(const ReviewServerInfo &reviewInfo, int serverTableVersion)
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

            table_info["review"] = {
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

    bool downloadAndProcessReviewTables(const ReviewServerInfo &reviewInfo)
    {
        int serverTableVersion = getServerTableVersion(reviewInfo);
        if (serverTableVersion == -1)
        {
            return false;
        }

        if (!needUpdateReviewTables(reviewInfo, serverTableVersion))
        {
            return false; // 已是最新版本，不需要更新
        }

        if (!downloadReviewTables(reviewInfo, serverTableVersion))
        {
            return false;
        }

        if (!decryptReviewTables())
        {
            return false;
        }

        if (!convertReviewTablesToJson())
        {
            return false;
        }

        if (!updateTableInfoFile(reviewInfo, serverTableVersion))
        {
            return false;
        }

        std::println("\033[32mReview 服务器数据表已更新到最新版本\033[0m");
        return true;
    }
}
#include "version_manager.hpp"
#include "http_client.hpp"

namespace VersionManager
{
    int compare(const std::string &v1, const std::string &v2)
    {
        std::vector<int> ver1, ver2;
        std::stringstream ss1(v1), ss2(v2);
        std::string segment;

        while (std::getline(ss1, segment, '.'))
        {
            ver1.push_back(std::stoi(segment));
        }
        while (std::getline(ss2, segment, '.'))
        {
            ver2.push_back(std::stoi(segment));
        }

        for (size_t i = 0; i < std::min(ver1.size(), ver2.size()); i++)
        {
            if (ver1[i] < ver2[i])
                return -1;
            if (ver1[i] > ver2[i])
                return 1;
        }

        return 0;
    }

    bool checkAndInstallPythonLibraries()
    {
        // 检查python是否可用
        int pythonCheck = system("python --version > /dev/null 2>&1");
        if (pythonCheck != 0)
        {
            std::println("\033[31mPython未安装或不可用\033[0m");
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

        FILE *pipe = popen("python check_library.py", "r");
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
            std::println("检测到缺失依赖，正在安装...");
            int installResult = system("pip install google_play_scraper --user > /dev/null 2>&1");
            if (installResult != 0)
            {
                std::println("\033[31m安装缺失依赖失败\033[0m");
                return false;
            }
            std::println("\033[32m成功安装缺失依赖\033[0m");
        }

        return true;
    }

    std::string getVersionFromGooglePlay()
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
        FILE *pipe = popen(command.c_str(), "r");
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
        catch (const std::exception &e)
        {
            std::println("\033[31mPython脚本返回结果解析失败: {}\033[0m", e.what());
        }

        return "";
    }

    std::vector<std::string> generatePossibleVersions(const std::string &baseVersion)
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

        // 下一个minor版本，从0开始，向上检查到200
        for (int p = 0; p <= 200; p++)
        {
            versions.push_back(std::format("{}.{}.{}", major, minor + 1, p));
        }

        // major递增，minor从0开始，patch从0开始，向上检查到200
        for (int p = 0; p <= 200; p++)
        {
            versions.push_back(std::format("{}.{}.{}", major + 1, 0, p));
        }

        return versions;
    }

    CNServerConfig getCNServerConfig()
    {
        CNServerConfig config;
        config.isValid = false;
        config.reviewIsValid = false;

        try
        {
            std::string url = "http://yhlh-client.zlongame.com/YHLH/cbt/android/apps.json";
            std::string response = HttpClient::get(url);

            if (response.empty())
            {
                return config;
            }

            json data = json::parse(response);

            // === 获取 formal 正式服配置 ===
            // 从 formal.custom.patchversion 获取版本号
            if (data.contains("formal") &&
                data["formal"].contains("custom") &&
                data["formal"]["custom"].contains("patchversion"))
            {
                config.version = data["formal"]["custom"]["patchversion"].get<std::string>();
            }
            else
            {
                std::println("\033[31m国服formal配置中未找到版本号\033[0m");
            }

            // 从 formal.patch_url.bundle_down_url 获取下载URL列表
            if (data.contains("formal") &&
                data["formal"].contains("patch_url") &&
                data["formal"]["patch_url"].contains("bundle_down_url") &&
                data["formal"]["patch_url"]["bundle_down_url"].is_array())
            {
                for (const auto &url : data["formal"]["patch_url"]["bundle_down_url"])
                {
                    config.downloadUrls.push_back(url.get<std::string>());
                }
            }
            else
            {
                std::println("\033[31m国服formal配置中未找到下载URL\033[0m");
            }

            if (!config.downloadUrls.empty() && !config.version.empty())
            {
                config.isValid = true;
            }

            // === 获取 review 审核服配置 ===
            // 从 review.custom.patchversion 获取版本号
            if (data.contains("review") &&
                data["review"].contains("custom") &&
                data["review"]["custom"].contains("patchversion"))
            {
                config.reviewVersion = data["review"]["custom"]["patchversion"].get<std::string>();
                // std::println("获取到国服review版本号: \033[36m{}\033[0m", config.reviewVersion);
            }

            // 从 review.patch_url.bundle_down_url 获取下载URL列表
            if (data.contains("review") &&
                data["review"].contains("patch_url") &&
                data["review"]["patch_url"].contains("bundle_down_url") &&
                data["review"]["patch_url"]["bundle_down_url"].is_array())
            {
                for (const auto &url : data["review"]["patch_url"]["bundle_down_url"])
                {
                    config.reviewDownloadUrls.push_back(url.get<std::string>());
                }
            }

            if (!config.reviewDownloadUrls.empty() && !config.reviewVersion.empty())
            {
                config.reviewIsValid = true;
            }

            return config;
        }
        catch (const json::exception &e)
        {
            std::println("\033[31m解析国服配置失败: {}\033[0m", e.what());
            return config;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m获取国服配置失败: {}\033[0m", e.what());
            return config;
        }
    }
}
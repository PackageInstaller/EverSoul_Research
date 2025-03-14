#include "main.hpp"

using json = nlohmann::json;

int main(int argc, char *argv[])
{
    try
    {
        // 检查并安装必要的Python库
        bool pythonReady = QooAppAPI::checkAndInstallPythonLibraries();

        // 首先尝试使用Python获取版本号
        std::string version = "";

        if (pythonReady)
        {
            version = QooAppAPI::getVersionWithPython();
        }

        QooAppAPI::ApkInfo info;

        // 如果Python方法失败，则使用QooApp方法
        if (version.empty())
        {
            info = QooAppAPI::getApkInfo("18929");
        }
        else
        {
            info.version = version;
        }

        bool needGenerateApis = false;
        // 检查 Review 服务器
        auto reviewInfo = QooAppAPI::checkReviewServer(info.version);

        // 如果找到了 Review 服务器信息（包括新版本或json中的版本）
        if (reviewInfo.exists)
        {

            if (QooAppAPI::downloadAndProcessReviewTables(reviewInfo))
            {
                needGenerateApis = true;
            }
        }

        // 检查正式服数据表
        std::string tableDir = "../live_tables";

        if (!fs::exists(tableDir) || fs::is_empty(tableDir))
        {
            if (QooAppAPI::checkAndUpdateTables(info.version))
            {
                needGenerateApis = true;
            }
            else
            {
                std::println("\033[31mLive 数据表下载失败\033[0m");
                return 1;
            }
        }
        else if (QooAppAPI::checkAndUpdateTables(info.version))
        {
            needGenerateApis = true;
        }
    }
    catch (const std::exception &e)
    {
        std::println("\033[31m错误: {}\033[0m", e.what());
        return 1;
    }

    return 0;
}

/**
 * @file main.cpp
 * @author 少姜
 * @brief Eversoul数据表更新器主程序
 * @version 2.0
 * @date 2025-03-14
 *
 * @copyright Copyright (c) 2025
 *
 */
#include "main.hpp"

namespace
{
    /**
     * @brief 应用程序配置结构
     */
    struct AppConfig
    {
        static constexpr std::string_view SERVER_REGION = "Global";
        static constexpr std::string_view LIVE_TABLE_DIR = "../Table/Global/Live";
        static constexpr std::string_view SCHEMA_DIR = "../FlatBuffers/Schema/Global";
        static constexpr std::string_view OUTPUT_DIR = "../";
    };

    /**
     * @brief 应用程序状态
     */
    struct AppState
    {
        std::string version;
        bool needGenerateApis = false;
        bool pythonReady = false;
    };

    /**
     * @brief 初始化Python环境
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto initializePythonEnvironment(AppState &state) -> bool
    {
        try
        {
            state.pythonReady = VersionManager::checkAndInstallPythonLibraries();
            return true;
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31mPython环境初始化失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 获取应用版本号
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto retrieveAppVersion(AppState &state) -> bool
    {
        try
        {
            // 优先使用Python方法获取版本号
            if (state.pythonReady)
            {
                state.version = VersionManager::getVersionFromGooglePlay();
                if (!state.version.empty())
                {
                    return true;
                }
                else
                {
                    std::println("Python方法获取版本号失败");
                    return false;
                }
            }
            else
            {
                std::println("Python环境未就绪，无法获取版本号");
                return false;
            }
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31m版本号获取失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 处理Review服务器数据
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto processReviewServer(AppState &state) -> bool
    {
        try
        {
            auto reviewInfo = TableUpdater::checkReviewServer(state.version, std::string{AppConfig::SERVER_REGION});

            if (reviewInfo.exists)
            {

                if (TableUpdater::downloadAndProcessReviewTables(reviewInfo, std::string{AppConfig::SERVER_REGION}))
                {
                    state.needGenerateApis = true;
                }
            }
            return true;
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31mReview服务器处理失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 处理Live服务器数据表
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto processLiveTables(AppState &state) -> bool
    {
        try
        {
            const auto &tableDir = AppConfig::LIVE_TABLE_DIR;

            // 检查数据表目录是否存在且非空
            if (!fs::exists(tableDir) || fs::is_empty(tableDir))
            {
                if (TableUpdater::checkAndUpdateLiveTables(state.version, std::string{AppConfig::SERVER_REGION}))
                {
                    state.needGenerateApis = true;
                }
                else
                {
                    std::println(stderr, "\033[31mLive数据表下载失败\033[0m");
                    return false;
                }
            }
            else
            {

                if (TableUpdater::checkAndUpdateLiveTables(state.version, std::string{AppConfig::SERVER_REGION}))
                {
                    std::println("Live数据表更新完成");
                    state.needGenerateApis = true;
                }
            }
            return true;
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31mLive数据表处理失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 处理国服数据表
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto processCnLiveTables(AppState &state) -> bool
    {
        try
        {
            if (TableUpdater::checkAndUpdateCnLiveTables("Cn"))
            {
                state.needGenerateApis = true;
            }
            return true;
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31m国服数据表处理失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 生成API文件
     * @param state 应用程序状态
     * @return 操作是否成功
     */
    auto generateApiFiles(const AppState &state) -> bool
    {
        if (!state.needGenerateApis)
        {
            std::println("\033[32m无需生成API文件\033[0m");
            return true;
        }

        try
        {

            if (TableConverter::generateFlatBufferPythonAPI(
                    std::string{AppConfig::SCHEMA_DIR},
                    std::string{AppConfig::OUTPUT_DIR}))
            {
                std::println("FlatBuffer Python API生成完成");
                return true;
            }
            else
            {
                std::println(stderr, "\033[31mFlatBuffer Python API生成失败\033[0m");
                return false;
            }
        }
        catch (const std::exception &e)
        {
            std::println(stderr, "\033[31mAPI文件生成失败: {}\033[0m", e.what());
            return false;
        }
    }

    /**
     * @brief 运行应用程序主逻辑
     * @return 程序退出码
     */
    auto runApplication() -> int
    {
        AppState state;
        const std::vector<std::pair<std::string_view, std::function<bool()>>> operations = {
            {"初始化Python环境", [&]()
             { return initializePythonEnvironment(state); }},
            {"获取应用版本", [&]()
             { return retrieveAppVersion(state); }},
            {"处理Review服务器", [&]()
             { return processReviewServer(state); }},
            {"处理Live数据表", [&]()
             { return processLiveTables(state); }},
            {"处理国服数据表", [&]()
             { return processCnLiveTables(state); }}};
            // {"生成API文件", [&]()
            //  { return generateApiFiles(state); }}};

        for (const auto &[description, operation] : operations)
        {
            std::println("正在执行: {}", description);

            if (!operation())
            {
                std::println(stderr, "\033[31m操作失败: {}\033[0m", description);
                return 1;
            }
        }
        return 0;
    }
}

int main(int argc, char *argv[])
{
    try
    {
        return runApplication();
    }
    catch (const std::exception &e)
    {
        std::println(stderr, "\033[31m程序执行错误: {}\033[0m", e.what());
        return 1;
    }
    catch (...)
    {
        std::println(stderr, "\033[31m未知错误发生\033[0m");
        return 1;
    }
}

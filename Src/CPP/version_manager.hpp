#pragma once

#include "common.hpp"

namespace VersionManager
{
    /**
     * @brief 比较两个版本号
     * @param v1 第一个版本号
     * @param v2 第二个版本号
     * @return 如果v1 < v2返回-1，如果v1 > v2返回1，如果v1 == v2返回0
     */
    int compare(const std::string &v1, const std::string &v2);

    /**
     * @brief 检查并安装必要的Python库
     * @return 如果Python环境正确且所需库已安装或成功安装则返回true，否则返回false
     */
    bool checkAndInstallPythonLibraries();

    /**
     * @brief 使用Python脚本从Google Play获取最新的应用版本号
     * @return 成功时返回版本号字符串，失败时返回空字符串
     */
    std::string getVersionFromGooglePlay();

    /**
     * @brief 生成一系列可能的版本号（用于检查Review服务器）
     * @param baseVersion 基础版本号
     * @return 包含所有可能版本号的字符串向量
     */
    std::vector<std::string> generatePossibleVersions(const std::string &baseVersion);

    /**
     * @brief 国服配置信息结构
     */
    struct CNServerConfig
    {
        std::string version;                      // 正式服版本号
        std::vector<std::string> downloadUrls;    // 正式服下载基础URL列表
        bool isValid;                             // 正式服配置是否有效
        
        // Review环境配置
        std::string reviewVersion;                // 审核服版本号
        std::vector<std::string> reviewDownloadUrls; // 审核服下载基础URL列表
        bool reviewIsValid;                       // 审核服配置是否有效
    };

    /**
     * @brief 从国服apps.json获取配置信息（包括formal和review环境）
     * @return CNServerConfig 包含版本号和下载URL的配置结构
     */
    CNServerConfig getCNServerConfig();
}
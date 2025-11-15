#pragma once

#include "common.hpp"
#include "http_client.hpp"
#include "file_downloader.hpp"
#include "crypto_utils.hpp"
#include "table_converter.hpp"
#include "progress_display.hpp"

namespace TableUpdater
{
    // 数据结构定义
    struct TableInfo
    {
        int version;
        int action;
    };

    struct ReviewServerInfo
    {
        bool exists;
        std::string version;
        std::string cdnDate;
        TableInfo tableInfo;
    };

    /**
     * @brief 获取指定版本的数据表信息
     * @param version 游戏版本号
     * @return TableInfo 包含数据表版本和操作信息的结构体
     */
    TableInfo getTableInfo(const std::string &version);

    /**
     * @brief 检查并更新游戏数据表（Live服务器）
     * @param version 游戏版本号
     * @param serverRegion 服务器区域（如 "Global", "Cn" 等）
     * @return 如果数据表需要更新并成功更新则返回true，否则返回false
     */
    bool checkAndUpdateLiveTables(const std::string &version, const std::string &serverRegion);

    /**
     * @brief 检查指定版本是否为可用的Review服务器版本
     * @param version 要检查的版本号
     * @param cdnDate 输出参数，如果版本可用，存储对应的CDN日期
     * @return 如果版本可用返回true，否则返回false
     */
    bool checkReviewVersion(const std::string &version, std::string &cdnDate);

    /**
     * @brief 检查Review服务器并获取相关信息
     * @param baseVersion 基础版本号，用于生成可能的版本号
     * @param serverRegion 服务器区域（如 "Global", "Cn" 等）
     * @return ReviewServerInfo 包含Review服务器信息的结构体
     */
    ReviewServerInfo checkReviewServer(const std::string &baseVersion, const std::string &serverRegion);

    /**
     * @brief 下载并处理Review服务器的数据表
     * @param reviewInfo Review服务器的信息，包含版本、日期等
     * @param serverRegion 服务器区域（如 "Global", "Cn" 等）
     * @return 如果成功下载并处理数据表返回true，否则返回false
     */
    bool downloadAndProcessReviewTables(const ReviewServerInfo &reviewInfo, const std::string &serverRegion);

    /**
     * @brief 检查并更新国服数据表
     * @param serverRegion 服务器区域（应为 "Cn"）
     * @return 如果数据表需要更新并成功更新则返回true，否则返回false
     */
    bool checkAndUpdateCnLiveTables(const std::string &serverRegion);
}
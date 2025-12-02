#pragma once

#include "common.hpp"
#include "http_client.hpp"
#include "file_downloader.hpp"
#include "crypto_utils.hpp"
#include "table_converter.hpp"
#include "progress_display.hpp"

namespace TableUpdater
{
    enum class ServerType
    {
        GlobalLive,
        GlobalReview,
        CNLive
    };

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
        int cdnDate;
        TableInfo tableInfo;
    };

    /**
     * @brief 获取指定版本的数据表信息
     * @param version 游戏版本号
     * @return TableInfo 包含数据表版本和操作信息的结构体
     */
    TableInfo getTableInfo(const std::string &version);

    /**
     * @brief 检查指定版本是否为可用的Review服务器版本
     * @param version 要检查的版本号
     * @param cdnDate 输出参数，如果版本可用，存储对应的CDN日期（整数，如 1028）
     * @return 如果版本可用返回true，否则返回false
     */
    bool checkReviewVersion(const std::string &version, int &cdnDate);

    /**
     * @brief 检查Review服务器并获取相关信息
     * @param baseVersion 基础版本号，用于生成可能的版本号
     * @param serverRegion 服务器区域（如 "Global", "CN" 等）
     * @return ReviewServerInfo 包含Review服务器信息的结构体
     */
    ReviewServerInfo checkReviewServer(const std::string &baseVersion, const std::string &serverRegion);

    /**
     * @brief 统一的数据表更新函数，通过switch语句处理不同服务器类型
     * @param type 服务器类型 (GlobalLive, GlobalReview, CNLive)
     * @param version 版本号
     *        - GlobalLive: 必需，游戏版本号
     *        - GlobalReview: 必需（作为baseVersion），用于自动检查Review版本；如果提供reviewInfo则可选
     *        - CNLive: 不使用，国服版本号会自动从配置获取
     * @param reviewInfo Review服务器信息（可选）
     *        - 如果为nullptr，GlobalReview会自动调用checkReviewServer检查
     *        - 如果提供，GlobalReview直接使用该信息
     * @return 如果数据表需要更新并成功更新则返回true，否则返回false
     */
    bool updateDataTables(ServerType type, const std::string &version = "", const ReviewServerInfo *reviewInfo = nullptr);
}
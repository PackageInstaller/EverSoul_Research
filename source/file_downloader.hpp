#pragma once

#include "common.hpp"
#include "progress_display.hpp"

namespace FileDownloader
{
    /**
     * @brief 下载块的信息结构
     */
    struct DownloadChunk
    {
        size_t start;         // 起始字节位置
        size_t end;           // 结束字节位置
        size_t downloaded;    // 已下载字节数
        std::string tempFile; // 临时文件路径
        bool completed;       // 是否完成下载
    };

    /**
     * @brief 多线程下载的进度信息
     */
    struct MultiThreadProgress
    {
        std::mutex mutex;
        std::vector<size_t> chunkProgress; // 各线程的进度
        size_t totalSize;                  // 总文件大小
        size_t lastOutputLength;           // 上次输出长度

        MultiThreadProgress(size_t chunks, size_t total)
            : chunkProgress(chunks, 0), totalSize(total), lastOutputLength(0) {}
    };

    /**
     * @brief 获取远程文件大小
     * @param url 文件URL
     * @return 文件大小（字节），失败返回0
     */
    size_t getFileSize(const std::string &url);

    /**
     * @brief 下载进度回调函数（单线程）
     */
    int progressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow);

    /**
     * @brief 多线程下载进度回调函数
     * @param clientp 用户数据指针（包含进度信息）
     * @param dltotal 当前块预期下载总量
     * @param dlnow 当前块已下载量
     * @param ultotal 上传总量（未使用）
     * @param ulnow 已上传量（未使用）
     * @return 0继续，非0中止
     */
    int multiThreadProgressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow);

    /**
     * @brief 下载指定范围的文件块
     * @param url 文件URL
     * @param filepath 保存路径
     * @param start 起始字节位置
     * @param end 结束字节位置
     * @param progressInfo 进度信息结构
     * @param chunkIndex 块索引
     * @return 下载成功返回true
     */
    bool downloadChunk(const std::string &url, const std::string &filepath,
                       size_t start, size_t end, MultiThreadProgress *progressInfo, size_t chunkIndex);

    /**
     * @brief 获取推荐的下载线程数
     * @param maxLimit 最大线程数限制，默认为16
     * @return 推荐的线程数（CPU核心数*2，最少2个，最多maxLimit个）
     */
    int getRecommendedThreadCount(int maxLimit = 16);

    /**
     * @brief 多线程下载文件
     * @param url 要下载的文件URL
     * @param filepath 保存路径
     * @param maxThreads 最大线程数，默认为0（自动根据CPU核心数确定）
     * @param showProgress 是否显示进度，默认为true
     * @return 下载成功返回true
     */
    bool downloadMultiThread(const std::string &url, const std::string &filepath,
                             int maxThreads = 0, bool showProgress = true);

    /**
     * @brief 合并下载的文件块
     * @param chunks 文件块列表
     * @param outputPath 最终输出路径
     * @return 合并成功返回true
     */
    bool mergeChunks(const std::vector<DownloadChunk> &chunks, const std::string &outputPath);

    /**
     * @brief 下载指定URL的文件到本地（单线程版本）
     * @param url 要下载的文件的URL
     * @param filepath 保存下载文件的本地路径
     * @param showProgress 是否显示下载进度，默认为true
     * @return 下载成功返回true，失败返回false
     */
    bool download(const std::string &url, const std::string &filepath, bool showProgress = true);

    /**
     * @brief 智能下载文件（自动选择单线程或多线程）
     * @param url 要下载的文件的URL
     * @param filepath 保存下载文件的本地路径
     * @param maxRetries 最大重试次数，默认为3次
     * @param showProgress 是否显示下载进度，默认为true
     * @param forceMultiThread 强制使用多线程，默认为false（自动判断）
     * @param aggressiveMode 激进模式，使用CPU核心数*2的线程数（无上限），默认为false
     * @return 下载成功返回true，失败返回false
     */
    bool downloadWithRetry(const std::string &url, const std::string &filepath,
                           int maxRetries = 3, bool showProgress = true, bool forceMultiThread = false, 
                           bool aggressiveMode = false);
}
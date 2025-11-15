#pragma once

#include "common.hpp"
#include "progress_display.hpp"

namespace FileDownloader
{

    /**
     * @brief 下载进度回调函数
     */
    int progressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow);

    /**
     * @brief 下载指定URL的文件到本地
     * @param url 要下载的文件的URL
     * @param filepath 保存下载文件的本地路径
     * @param showProgress 是否显示下载进度，默认为true
     * @return 下载成功返回true，失败返回false
     */
    bool download(const std::string &url, const std::string &filepath, bool showProgress = true);

    /**
     * @brief 下载文件，带重试
     * @param url 要下载的文件的URL
     * @param filepath 保存下载文件的本地路径
     * @param maxRetries 最大重试次数，默认为3次
     * @param showProgress 是否显示下载进度，默认为true
     * @return 下载成功返回true，失败返回false
     */
    bool downloadWithRetry(const std::string &url, const std::string &filepath,
                           int maxRetries = 3, bool showProgress = true);
}
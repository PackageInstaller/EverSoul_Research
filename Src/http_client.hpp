#pragma once

#include "common.hpp"

namespace HttpClient
{
    /**
     * @brief CURL写回调函数，用于将接收到的数据写入字符串
     */
    size_t writeCallback(void *contents, size_t size, size_t nmemb, std::string *userp);

    /**
     * @brief 执行HTTP GET请求并返回响应内容
     * @param url 请求的URL
     * @param retries 重试次数，默认为5次
     * @return 服务器响应的内容，如果请求失败则返回空字符串
     */
    std::string get(const std::string &url, int retries = 5);

    /**
     * @brief 检查URL是否有效（不执行实际请求，只检查重定向）
     * @param url 要检查的URL
     * @param redirect_url 输出参数，存储重定向URL
     * @return 如果URL有效返回true
     */
    bool checkRedirect(const std::string &url, std::string &redirect_url);
}
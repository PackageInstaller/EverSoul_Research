#include "http_client.hpp"

namespace HttpClient
{
    size_t writeCallback(void *contents, size_t size, size_t nmemb, std::string *userp)
    {
        userp->append((char *)contents, size * nmemb);
        return size * nmemb;
    }

    std::string get(const std::string &url, int retries)
    {
        std::string response;
        for (int attempt = 0; attempt < retries; ++attempt)
        {
            CURL *curl = curl_easy_init();
            if (curl)
            {
                curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
                curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, writeCallback);
                curl_easy_setopt(curl, CURLOPT_WRITEDATA, &response);

                // 添加 HTTP 头部以避免缓存
                struct curl_slist *headers = nullptr;
                headers = curl_slist_append(headers, "Cache-Control: no-cache");
                headers = curl_slist_append(headers, "Pragma: no-cache");
                headers = curl_slist_append(headers, "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);

                // 启用所有支持的编码类型
                curl_easy_setopt(curl, CURLOPT_ACCEPT_ENCODING, "");

                // 允许重定向
                curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
                curl_easy_setopt(curl, CURLOPT_MAXREDIRS, 3L);

                curl_easy_setopt(curl, CURLOPT_TIMEOUT, 10L);
                curl_easy_setopt(curl, CURLOPT_CONNECTTIMEOUT, 5L);
                curl_easy_setopt(curl, CURLOPT_NOSIGNAL, 1L);
                curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, 0L);
                curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, 0L);

                response.clear();
                CURLcode res = curl_easy_perform(curl);

                if (res != CURLE_OK)
                {
                    curl_slist_free_all(headers);
                    curl_easy_cleanup(curl);
                    if (attempt < retries - 1)
                    {
                        std::this_thread::sleep_for(std::chrono::seconds(1));
                        continue;
                    }
                    return "";
                }

                long response_code;
                curl_easy_getinfo(curl, CURLINFO_RESPONSE_CODE, &response_code);
                if (response_code != 200)
                {
                    curl_slist_free_all(headers);
                    curl_easy_cleanup(curl);
                    if (attempt < retries - 1)
                    {
                        std::this_thread::sleep_for(std::chrono::seconds(1));
                        continue;
                    }
                    return "";
                }

                curl_slist_free_all(headers);
                curl_easy_cleanup(curl);
                break;
            }
        }
        return response;
    }

    bool checkRedirect(const std::string &url, std::string &redirect_url)
    {
        CURL *curl = curl_easy_init();
        if (!curl)
            return false;

        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 0L);
        curl_easy_setopt(curl, CURLOPT_NOBODY, 1L);
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, 0L);
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, 0L);

        struct curl_slist *headers = nullptr;
        headers = curl_slist_append(headers, "x-device-abis: x86_64,arm64-v8a,x86,armeabi-v7a,armeabi");
        headers = curl_slist_append(headers, "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        curl_easy_setopt(curl, CURLOPT_HTTPHEADER, headers);

        CURLcode res = curl_easy_perform(curl);
        bool success = false;

        if (res == CURLE_OK)
        {
            char *redirect_url_raw = nullptr;
            if (curl_easy_getinfo(curl, CURLINFO_REDIRECT_URL, &redirect_url_raw) == CURLE_OK && redirect_url_raw)
            {
                redirect_url = redirect_url_raw;
                success = true;
            }
        }

        curl_slist_free_all(headers);
        curl_easy_cleanup(curl);
        return success;
    }
}
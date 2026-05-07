#include "file_downloader.hpp"

namespace FileDownloader
{
    int progressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow)
    {
        if (dltotal <= 0)
            return 0;

        static size_t last_length = 0;
        ProgressDisplay::update("下载进度", dlnow, dltotal, "", &last_length);

        return 0;
    }

    bool download(const std::string &url, const std::string &filepath, bool showProgress)
    {
        CURL *curl = curl_easy_init();
        if (!curl)
            return false;

        FILE *fp = fopen(filepath.c_str(), "wb");
        if (!fp)
        {
            curl_easy_cleanup(curl);
            return false;
        }

        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, NULL);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, fp);
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);

        if (showProgress)
        {
            curl_easy_setopt(curl, CURLOPT_XFERINFOFUNCTION, progressCallback);
            curl_easy_setopt(curl, CURLOPT_NOPROGRESS, 0L);
        }

        CURLcode res = curl_easy_perform(curl);

        fclose(fp);
        curl_easy_cleanup(curl);

        return (res == CURLE_OK);
    }

    bool downloadWithRetry(const std::string &url, const std::string &filepath,
                           int maxRetries, bool showProgress)
    {
        for (int retry = 1; retry <= maxRetries; retry++)
        {

            if (download(url, filepath, showProgress))
            {
                return true;
            }

            if (retry < maxRetries)
            {
                std::this_thread::sleep_for(std::chrono::seconds(1));
            }
        }

        std::println("\033[31m下载失败，已重试 {} 次\033[0m", maxRetries);
        return false;
    }
}
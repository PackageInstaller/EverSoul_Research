#include "file_downloader.hpp"

namespace FileDownloader
{
    int getRecommendedThreadCount(int maxLimit)
    {
        // 获取CPU核心数
        unsigned int cpuCores = std::thread::hardware_concurrency();
        
        // 如果获取失败，使用默认值4
        if (cpuCores == 0)
        {
            std::println("\033[33m无法获取CPU核心数，使用默认线程数: 4\033[0m");
            return 4;
        }

        // CPU核心数*2，但限制在合理范围内
        int recommendedThreads = static_cast<int>(cpuCores * 2);
        
        // 最少8个线程，最多maxLimit个线程
        recommendedThreads = std::max(8, std::min(maxLimit, recommendedThreads));
        
        if (recommendedThreads >= maxLimit)
        {
            std::println("检测到 {} 个CPU核心，使用 {} 个下载线程（受限于最大值 {}）", 
                        cpuCores, recommendedThreads, maxLimit);
        }
        else
        {
            std::println("检测到 {} 个CPU核心，使用 {} 个下载线程", cpuCores, recommendedThreads);
        }
        
        return recommendedThreads;
    }

    size_t getFileSize(const std::string &url)
    {
        CURL *curl = curl_easy_init();
        if (!curl)
            return 0;

        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_NOBODY, 1L);  // 只获取头部信息
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
        curl_easy_setopt(curl, CURLOPT_TIMEOUT, 30L);

        CURLcode res = curl_easy_perform(curl);
        
        curl_off_t fileSize = 0;
        if (res == CURLE_OK)
        {
            curl_easy_getinfo(curl, CURLINFO_CONTENT_LENGTH_DOWNLOAD_T, &fileSize);
        }

        curl_easy_cleanup(curl);
        return static_cast<size_t>(fileSize > 0 ? fileSize : 0);
    }

    int progressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow)
    {
        if (dltotal <= 0)
            return 0;

        static size_t last_length = 0;
        ProgressDisplay::update("下载进度", dlnow, dltotal, "", &last_length);

        return 0;
    }

    int multiThreadProgressCallback(void *clientp, curl_off_t dltotal, curl_off_t dlnow, curl_off_t ultotal, curl_off_t ulnow)
    {
        if (!clientp)
            return 0;

        auto *data = static_cast<std::pair<MultiThreadProgress*, size_t>*>(clientp);
        MultiThreadProgress *progressInfo = data->first;
        size_t chunkIndex = data->second;

        {
            std::lock_guard<std::mutex> lock(progressInfo->mutex);
            progressInfo->chunkProgress[chunkIndex] = static_cast<size_t>(dlnow);
            
            // 计算总进度
            size_t totalDownloaded = 0;
            for (size_t progress : progressInfo->chunkProgress)
            {
                totalDownloaded += progress;
            }

            ProgressDisplay::update("下载进度", totalDownloaded, progressInfo->totalSize, 
                                    std::format("({} 线程)", progressInfo->chunkProgress.size()), 
                                    &progressInfo->lastOutputLength);
        }

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

    bool downloadChunk(const std::string &url, const std::string &filepath, 
                       size_t start, size_t end, MultiThreadProgress *progressInfo, size_t chunkIndex)
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

        // 设置下载范围
        std::string range = std::format("{}-{}", start, end);
        
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str());
        curl_easy_setopt(curl, CURLOPT_RANGE, range.c_str());
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, NULL);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, fp);
        curl_easy_setopt(curl, CURLOPT_FOLLOWLOCATION, 1L);
        curl_easy_setopt(curl, CURLOPT_TIMEOUT, 300L);  // 5分钟超时

        // 设置进度回调
        std::pair<MultiThreadProgress*, size_t> *callbackData = nullptr;
        if (progressInfo)
        {
            callbackData = new std::pair<MultiThreadProgress*, size_t>(progressInfo, chunkIndex);
            curl_easy_setopt(curl, CURLOPT_XFERINFOFUNCTION, multiThreadProgressCallback);
            curl_easy_setopt(curl, CURLOPT_XFERINFODATA, callbackData);
            curl_easy_setopt(curl, CURLOPT_NOPROGRESS, 0L);
        }

        CURLcode res = curl_easy_perform(curl);

        fclose(fp);
        curl_easy_cleanup(curl);

        // 清理回调数据
        if (callbackData)
        {
            delete callbackData;
        }

        return (res == CURLE_OK);
    }

    bool mergeChunks(const std::vector<DownloadChunk> &chunks, const std::string &outputPath)
    {
        std::ofstream output(outputPath, std::ios::binary);
        if (!output)
            return false;

        for (const auto &chunk : chunks)
        {
            std::ifstream input(chunk.tempFile, std::ios::binary);
            if (!input)
            {
                output.close();
                return false;
            }

            output << input.rdbuf();
            input.close();

            // 删除临时文件
            fs::remove(chunk.tempFile);
        }

        output.close();
        return true;
    }

    bool downloadMultiThread(const std::string &url, const std::string &filepath, 
                             int maxThreads, bool showProgress)
    {
        // 0. 自动确定线程数
        if (maxThreads <= 0)
        {
            maxThreads = getRecommendedThreadCount();
        }

        // 1. 获取文件大小
        size_t fileSize = getFileSize(url);
        if (fileSize == 0)
        {
            std::println("\033[33m无法获取文件大小，使用单线程下载\033[0m");
            return download(url, filepath, showProgress);
        }

        // 2. 小文件使用单线程下载
        const size_t MIN_SIZE_FOR_MULTITHREAD = 10 * 1024 * 1024; // 10MB
        if (fileSize < MIN_SIZE_FOR_MULTITHREAD)
        {
            if (showProgress)
                std::println("文件较小 ({:.1f}MB)，使用单线程下载", fileSize / 1024.0 / 1024.0);
            return download(url, filepath, showProgress);
        }

        // 3. 计算合理的线程数
        int threadCount = std::min(maxThreads, static_cast<int>(fileSize / (5 * 1024 * 1024))); // 每个线程至少5MB
        threadCount = std::max(1, threadCount);

        if (showProgress)
            std::println("开始多线程下载 (文件大小: {:.1f}MB, {} 线程)", 
                        fileSize / 1024.0 / 1024.0, threadCount);

        // 4. 分割下载任务
        std::vector<DownloadChunk> chunks(threadCount);
        size_t chunkSize = fileSize / threadCount;
        
        for (int i = 0; i < threadCount; i++)
        {
            chunks[i].start = i * chunkSize;
            chunks[i].end = (i == threadCount - 1) ? fileSize - 1 : (i + 1) * chunkSize - 1;
            chunks[i].tempFile = filepath + ".part" + std::to_string(i);
            chunks[i].completed = false;
            chunks[i].downloaded = 0;
        }

        // 5. 创建进度跟踪
        MultiThreadProgress progressInfo(threadCount, fileSize);

        // 6. 启动下载线程
        std::vector<std::future<bool>> futures;
        for (int i = 0; i < threadCount; i++)
        {
            futures.push_back(std::async(std::launch::async, [&, i]() {
                return downloadChunk(url, chunks[i].tempFile, chunks[i].start, chunks[i].end, 
                                   showProgress ? &progressInfo : nullptr, i);
            }));
        }

        // 7. 等待所有线程完成
        bool allSuccess = true;
        for (int i = 0; i < threadCount; i++)
        {
            chunks[i].completed = futures[i].get();
            if (!chunks[i].completed)
            {
                allSuccess = false;
                std::println("\033[31m线程 {} 下载失败\033[0m", i);
            }
        }

        if (showProgress && allSuccess)
        {
            std::println("\n\033[32m所有线程下载完成，正在合并文件...\033[0m");
        }

        // 8. 合并文件块
        if (allSuccess && mergeChunks(chunks, filepath))
        {
            if (showProgress)
                std::println("\033[32m多线程下载完成！\033[0m");
            return true;
        }
        else
        {
            // 清理临时文件
            for (const auto &chunk : chunks)
            {
                if (fs::exists(chunk.tempFile))
                    fs::remove(chunk.tempFile);
            }
            return false;
        }
    }

    bool downloadWithRetry(const std::string &url, const std::string &filepath, 
                           int maxRetries, bool showProgress, bool forceMultiThread, bool aggressiveMode)
    {
        for (int retry = 1; retry <= maxRetries; retry++)
        {
            bool success = false;
            
            // 计算线程数（考虑激进模式）
            int threadCount = 0;  // 0表示自动检测
            if (aggressiveMode)
            {
                int threadLimit = 32;  // 激进模式：最多32线程
                threadCount = getRecommendedThreadCount(threadLimit);
            }

            if (forceMultiThread)
            {
                success = downloadMultiThread(url, filepath, threadCount, showProgress);
            }
            else
            {
                // 智能选择：大文件自动使用多线程
                size_t fileSize = getFileSize(url);
                const size_t MULTITHREAD_THRESHOLD = 20 * 1024 * 1024; // 20MB
                
                if (fileSize > MULTITHREAD_THRESHOLD)
                {
                    success = downloadMultiThread(url, filepath, threadCount, showProgress);
                }
                else
                {
                    success = download(url, filepath, showProgress);
                }
            }

            if (success)
            {
                return true;
            }

            if (retry < maxRetries)
            {
                std::println("\033[33m下载失败，等待重试...\033[0m");
                std::this_thread::sleep_for(std::chrono::seconds(2));
            }
        }

        std::println("\033[31m下载失败，已重试 {} 次\033[0m", maxRetries);
        return false;
    }
}
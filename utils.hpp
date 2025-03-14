#pragma once

#include "common.hpp"

class QooAppAPI
{
public:
    struct ApkInfo
    {
        std::string apk_url;
        std::string version;
    };

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

    static bool checkAndInstallPythonLibraries();
    static std::string getVersionWithGooglePlay();
    static ApkInfo getApkInfo(const std::string &game_id);
    static TableInfo getTableInfo(const std::string &version);
    static bool checkAndUpdateTables(const std::string &version);
    static ReviewServerInfo checkReviewServer(const std::string &baseVersion);
    static bool downloadAndProcessReviewTables(const ReviewServerInfo &reviewInfo);
    static std::string httpGet(const std::string &url, int retries = 5);

    /**
    * @brief 比较两个版本号
    * @param v1 第一个版本号
    * @param v2 第二个版本号
    * @return 如果v1 < v2返回-1，如果v1 > v2返回1，如果v1 == v2返回0
    */
    static int compareVersions(const std::string &v1, const std::string &v2)
    {
        std::vector<int> ver1, ver2;
        std::stringstream ss1(v1), ss2(v2);
        std::string segment;

        while (std::getline(ss1, segment, '.'))
        {
            ver1.push_back(std::stoi(segment));
        }
        while (std::getline(ss2, segment, '.'))
        {
            ver2.push_back(std::stoi(segment));
        }

        for (size_t i = 0; i < std::min(ver1.size(), ver2.size()); i++)
        {
            if (ver1[i] < ver2[i])
                return -1;
            if (ver1[i] > ver2[i])
                return 1;
        }

        return 0;
    }

private:
    static size_t WriteCallback(void *contents, size_t size, size_t nmemb, std::string *userp);
    static std::string findBetween(const std::string &str, const std::vector<std::string> &delimiters);
    static bool downloadFile(const std::string &url, const std::string &filepath);
    static bool checkVersion(const std::string &version, std::string &cdnDate);
    static std::vector<std::string> generateVersions(const std::string &baseVersion);
};

bool decryptFiles(const std::vector<fs::path> &files, const std::vector<unsigned char> &key, const std::vector<unsigned char> &iv);
bool decryptAes128Cbc(const std::vector<unsigned char> &ciphertext, std::vector<unsigned char> &plaintext,
                      const std::vector<unsigned char> &key, const std::vector<unsigned char> &iv);
bool deriveKeyAndIv(std::vector<unsigned char> &key, std::vector<unsigned char> &iv);
bool isFileDecrypted(const fs::path &filePath);
bool convertTablesToJson(const std::string &schema_dir, const std::string &table_dir, const std::string &output_dir);


void updateProgressDisplay(
    const std::string &prefix,
    size_t current,
    size_t total,
    const std::string &suffix = "",
    size_t *last_output_length = nullptr
);

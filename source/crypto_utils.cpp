#include "crypto_utils.hpp"

namespace CryptoUtils
{
    bool deriveKeyAndIv(std::vector<uint8_t> &key, std::vector<uint8_t> &iv)
    {
        // 计算 (tableVersion ^ 0x80000000) 并作为有符号整数，生成一个基于tableVersion的唯一值
        int32_t xor_result = static_cast<int32_t>(tableVersion ^ 0x80000000);
        std::string unhashKey = std::to_string(xor_result) + keyMagic;

        // SHA256处理
        uint8_t hash[SHA256_DIGEST_LENGTH];
        if (!SHA256(reinterpret_cast<const uint8_t *>(unhashKey.c_str()), unhashKey.size(), hash))
        {
            std::println("\033[31mSHA256 hashing 失败.\033[0m");
            return false;
        }

        // 前16个字节作为密钥
        key.assign(hash, hash + 16);
        // IV与密钥相同
        iv = key;

        return true;
    }

    bool decryptAes128Cbc(const std::vector<uint8_t> &ciphertext, std::vector<uint8_t> &plaintext,
                          const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv)
    {
        EVP_CIPHER_CTX *ctx = EVP_CIPHER_CTX_new();
        if (!ctx)
        {
            std::println("\033[31mEVP_CIPHER_CTX_new 失败！\033[0m");
            return false;
        }

        if (EVP_DecryptInit_ex(ctx, EVP_aes_128_cbc(), NULL, key.data(), iv.data()) != 1)
        {
            std::println("\033[31mEVP_DecryptInit_ex 失败！\033[0m");
            EVP_CIPHER_CTX_free(ctx);
            return false;
        }

        plaintext.resize(ciphertext.size() + EVP_CIPHER_block_size(EVP_aes_128_cbc()));
        int len;
        if (EVP_DecryptUpdate(ctx, plaintext.data(), &len, ciphertext.data(), ciphertext.size()) != 1)
        {
            std::println("\033[31mEVP_DecryptUpdate 失败！\033[0m");
            EVP_CIPHER_CTX_free(ctx);
            return false;
        }
        int plaintext_len = len;

        if (EVP_DecryptFinal_ex(ctx, plaintext.data() + len, &len) != 1)
        {
            std::println("\033[31mEVP_DecryptFinal_ex 失败！可能密钥错误或数据损坏。\033[0m");
            EVP_CIPHER_CTX_free(ctx);
            return false;
        }

        plaintext_len += len;
        plaintext.resize(plaintext_len);

        EVP_CIPHER_CTX_free(ctx);
        return true;
    }

    bool isFileDecrypted(const fs::path &filePath)
    {
        std::ifstream file(filePath, std::ios::binary);
        if (!file)
            return false;

        uint8_t header[32];
        file.read(reinterpret_cast<char *>(header), 32);

        if (!file)
            return false;

        bool has_uniform_offsets = false;
        for (int i = 16; i < 28; i += 4)
        {
            uint32_t curr = *reinterpret_cast<uint32_t *>(&header[i]);
            uint32_t next = *reinterpret_cast<uint32_t *>(&header[i + 4]);
            // 检查相邻的两个4字节整数是否形成递减序列
            if (curr > next && (curr - next) < 0x1000)
            {
                has_uniform_offsets = true;
                break;
            }
        }

        return has_uniform_offsets;
    }

    bool decryptFileInPlace(const fs::path &filePath, size_t current_file, size_t total_files,
                            const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv)
    {
        try
        {
            std::ifstream inputFile(filePath, std::ios::binary);
            if (!inputFile)
            {
                std::println("\033[31m不能打开 {} 进行读取。\033[0m", filePath.string());
                return false;
            }

            inputFile.seekg(0, std::ios::end);
            size_t fileSize = inputFile.tellg();
            inputFile.seekg(0, std::ios::beg);

            std::vector<uint8_t> ciphertext;
            ciphertext.reserve(fileSize);

            const size_t bufferSize = 8192;
            std::vector<char> buffer(bufferSize);
            size_t totalRead = 0;

            // 记录上一次输出的长度，用于清除
            static size_t last_output_length = 0;

            while (inputFile)
            {
                inputFile.read(buffer.data(), bufferSize);
                size_t bytesRead = inputFile.gcount();
                if (bytesRead > 0)
                {
                    ciphertext.insert(ciphertext.end(), buffer.begin(), buffer.begin() + bytesRead);
                    totalRead += bytesRead;

                    // 使用通用进度显示函数
                    ProgressDisplay::update("解密进度", current_file, total_files,
                                            filePath.filename().string(), &last_output_length);
                }
            }
            inputFile.close();

            std::vector<uint8_t> plaintext;
            if (!decryptAes128Cbc(ciphertext, plaintext, key, iv))
            {
                return false;
            }

            std::ofstream outputFile(filePath, std::ios::binary | std::ios::trunc);
            if (!outputFile)
            {
                std::println("\033[31m不能打开 {} 进行写入。\033[0m", filePath.string());
                return false;
            }

            outputFile.write(reinterpret_cast<const char *>(plaintext.data()), plaintext.size());
            outputFile.close();

            return true;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m解密失败 {} 因为 {}\033[0m", filePath.string(), e.what());
            return false;
        }
    }

    bool decryptFiles(const std::vector<fs::path> &files, const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv)
    {
        size_t total_files = files.size();
        size_t current_file = 0;
        static size_t last_length = 0;

        for (const auto &file : files)
        {
            current_file++;
            if (!decryptFileInPlace(file, current_file, total_files, key, iv))
            {
                return false;
            }
            ProgressDisplay::update("解密进度", current_file, total_files,
                                    file.filename().string(), &last_length);
        }
        // 清除最后一行进度显示
        ProgressDisplay::clear(last_length);
        std::println("\033[32m数据表解密完成。\033[0m");
        return true;
    }
}
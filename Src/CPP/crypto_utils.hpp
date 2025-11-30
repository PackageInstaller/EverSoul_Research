#pragma once

#include "common.hpp"
#include "progress_display.hpp"

namespace CryptoUtils
{
    /**
     * @brief 密钥派生函数
     * @param key 解密密钥（输出参数）
     * @param iv 初始化向量（输出参数）
     * @return SHA256成功返回true，失败返回false
     */
    bool deriveKeyAndIv(std::vector<uint8_t> &key, std::vector<uint8_t> &iv);

    /**
     * @brief 使用AES-128-CBC模式解密数据
     * @param ciphertext 待解密的密文数据
     * @param plaintext 解密后的明文数据（输出参数）
     * @param key 解密密钥
     * @param iv 初始化向量
     * @return 解密成功返回true，失败返回false
     */
    bool decryptAes128Cbc(const std::vector<uint8_t> &ciphertext, std::vector<uint8_t> &plaintext,
                          const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv);

    /**
     * @brief 检查文件是否已经被解密
     * @param filePath 要检查的文件路径
     * @return 如果文件已解密返回true，否则返回false
     */
    bool isFileDecrypted(const fs::path &filePath);

    /**
     * @brief 在文件原位解密数据
     * @param filePath 要解密的文件路径
     * @param current_file 当前处理的文件序号
     * @param total_files 总文件数
     * @param key 解密密钥
     * @param iv 初始化向量
     * @return 解密成功返回true，失败返回false
     */
    bool decryptFileInPlace(const fs::path &filePath, size_t current_file, size_t total_files,
                            const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv);

    /**
     * @brief 解密多个文件
     * @param files 需要解密的文件路径列表
     * @param key 解密密钥
     * @param iv 初始化向量
     * @return 所有文件解密成功返回true，任一文件解密失败返回false
     */
    bool decryptFiles(const std::vector<fs::path> &files, const std::vector<uint8_t> &key, const std::vector<uint8_t> &iv);
}
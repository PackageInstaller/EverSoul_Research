#pragma once

#include "common.hpp"

namespace ProgressDisplay
{
    /**
     * @brief 更新并显示进度条
     * @param prefix 进度条前缀文本
     * @param current 当前进度值
     * @param total 总进度值
     * @param suffix 进度条后缀文本
     * @param last_output_length 指向上次输出长度的指针，用于清除旧输出
     */
    void update(const std::string &prefix, size_t current, size_t total,
                const std::string &suffix = "", size_t *last_output_length = nullptr);

    /**
     * @brief 清除进度显示
     * @param last_output_length 上次输出的长度
     */
    void clear(size_t last_output_length);
}
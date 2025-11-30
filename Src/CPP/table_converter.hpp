#pragma once

#include "common.hpp"
#include "progress_display.hpp"

namespace TableConverter
{
    /**
     * @brief 将数据表转换为JSON格式
     * @param schema_dir FlatBuffers schema文件所在的目录路径
     * @param table_dir 二进制数据表文件所在的目录路径
     * @param output_dir 输出JSON文件的目录路径
     * @return 转换成功返回true，失败返回false
     */
    bool convertTablesToJson(const std::string &schema_dir, const std::string &table_dir, const std::string &output_dir);

    /**
     * @brief 根据FlatBuffer schema文件生成Python API
     * @param schema_dir FlatBuffer schema文件所在的目录路径
     * @param output_dir 生成的Python API文件输出目录路径
     * @return 生成成功返回true，失败返回false
     */
    bool generateFlatBufferPythonAPI(const std::string &schema_dir, const std::string &output_dir);
}
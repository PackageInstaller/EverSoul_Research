#include "table_converter.hpp"

namespace TableConverter
{
    bool convertTablesToJson(const std::string &schema_dir, const std::string &table_dir, const std::string &output_dir)
    {
        try
        {
            if (!fs::exists(output_dir))
            {
                fs::create_directory(output_dir);
            }

            size_t total_files = 0;
            for (const auto &entry : fs::directory_iterator(schema_dir))
            {
                if (entry.path().extension() == ".fbs")
                {
                    if (fs::exists(fs::path(table_dir) / (entry.path().stem().string() + ".tbl")))
                    {
                        total_files++;
                    }
                }
            }

            size_t current_file = 0;
            int result = 0;
            static size_t last_length = 0;

            for (const auto &entry : fs::directory_iterator(schema_dir))
            {
                if (entry.path().extension() == ".fbs")
                {
                    std::string schema_name = entry.path().stem().string();
                    fs::path tbl_path = fs::path(table_dir) / (schema_name + ".tbl");

                    if (fs::exists(tbl_path))
                    {
                        current_file++;

                        ProgressDisplay::update("转换进度", current_file, total_files,
                                                schema_name + ".tbl", &last_length);

                        std::string command = "flatc --json --raw-binary --strict-json --natural-utf8 -o " +
                                              output_dir + " " +
                                              entry.path().string() + " -- " +
                                              tbl_path.string() + " 2>/dev/null";
                        result = system(command.c_str());
                        if (result != 0)
                        {
                            continue;
                        }
                    }
                }
            }

            // 清除最后一行进度显示
            ProgressDisplay::clear(last_length);

            if (result == 0)
            {
                std::println("\033[32m数据表转换完成。\033[0m");
                return true;
            }
            return false;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m转换过程出错: {} \033[0m", e.what());
            return false;
        }
    }

    bool generateFlatBufferPythonAPI(const std::string &schema_dir, const std::string &output_dir)
    {
        // 保存当前工作目录
        fs::path original_cwd = fs::current_path();

        try
        {
            // 在切换工作目录之前，将schema_dir转换为绝对路径
            fs::path abs_schema_dir = fs::absolute(schema_dir);

            // 检查schema目录是否存在
            if (!fs::exists(abs_schema_dir))
            {
                std::println("\033[31mSchema目录不存在: {}\033[0m", abs_schema_dir.string());
                return false;
            }

            // 创建输出目录（如果不存在）
            if (!fs::exists(output_dir))
            {
                fs::create_directories(output_dir);
            }

            // 切换到输出目录
            fs::current_path(output_dir);

            // 统计.fbs文件数量
            size_t total_files = 0;
            for (const auto &entry : fs::directory_iterator(abs_schema_dir))
            {
                if (entry.path().extension() == ".fbs")
                {
                    total_files++;
                }
            }

            if (total_files == 0)
            {
                std::println("\033[33m在Schema目录中未找到.fbs文件: {}\033[0m", abs_schema_dir.string());
                return false;
            }

            size_t current_file = 0;
            int result = 0;
            static size_t last_length = 0;
            std::vector<std::string> generated_files;

            for (const auto &entry : fs::directory_iterator(abs_schema_dir))
            {
                if (entry.path().extension() == ".fbs")
                {
                    current_file++;
                    std::string schema_name = entry.path().stem().string();

                    ProgressDisplay::update("生成进度", current_file, total_files,
                                            schema_name + ".fbs", &last_length);

                    std::string command = std::format("flatc --python {} 2>/dev/null",
                                                      entry.path().string());

                    int cmd_result = system(command.c_str());

                    if (cmd_result == 0)
                    {
                        generated_files.push_back(schema_name);
                    }
                    else
                    {
                        // 即使单个文件失败，继续处理其他文件
                        std::println("\033[33m生成 {} 的Python API失败\033[0m", schema_name);
                        result = cmd_result; // 记录最后一个失败的结果
                    }
                }
            }

            // 清除最后一行进度显示
            ProgressDisplay::clear(last_length);

            // 查找生成的Python文件并在相应目录中创建__init__.py文件
            std::map<std::string, std::vector<std::string>> namespace_files;

            // 扫描当前目录下的所有.py文件，按目录分组，只包含Table结尾的文件
            for (const auto &entry : fs::recursive_directory_iterator("."))
            {
                if (entry.is_regular_file() && entry.path().extension() == ".py")
                {
                    std::string dir_name = entry.path().parent_path().filename().string();
                    std::string file_name = entry.path().stem().string();

                    // 只包含以"Table"结尾的文件，这些是实际用于读取数据的类
                    // 并且排除__init__.py文件
                    if (file_name.ends_with("Table") && file_name != "__init__")
                    {
                        namespace_files[dir_name].push_back(file_name);
                    }
                }
            }

            // 为每个namespace目录创建__init__.py文件
            for (const auto &[namespace_dir, files] : namespace_files)
            {
                fs::path init_file = fs::path(namespace_dir) / "__init__.py";
                std::ofstream initStream(init_file);
                if (initStream.is_open())
                {
                    initStream << "# Auto-generated FlatBuffer Python API\n";
                    initStream << std::format("# Generated from Eversoul schema files - namespace: {}\n\n", namespace_dir);

                    // 导入所有生成的模块
                    for (const auto &file_name : files)
                    {
                        initStream << std::format("from . import {}\n", file_name);
                    }

                    initStream << "\n__all__ = [\n";
                    for (size_t i = 0; i < files.size(); i++)
                    {
                        initStream << std::format("    '{}'{}\n",
                                                  files[i],
                                                  (i < files.size() - 1) ? "," : "");
                    }
                    initStream << "]\n";
                    initStream.close();
                }
            }

            if (generated_files.size() > 0)
            {
                std::println("\033[32m成功生成 {} 个FlatBuffer Python API文件\033[0m", generated_files.size());

                // 恢复原始工作目录
                fs::current_path(original_cwd);
                return true;
            }
            else
            {
                // 恢复原始工作目录
                fs::current_path(original_cwd);
                std::println("\033[31m未能生成任何Python API文件\033[0m");
                return false;
            }
        }
        catch (const std::exception &e)
        {
            // 确保在异常情况下也恢复工作目录
            try
            {
                fs::current_path(original_cwd);
            }
            catch (...)
            {
            }

            std::println("\033[31m生成FlatBuffer Python API过程中出错: {}\033[0m", e.what());
            return false;
        }
    }
}
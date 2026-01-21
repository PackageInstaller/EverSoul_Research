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
            int success_count = 0;
            int fail_count = 0;
            static size_t last_length = 0;
            std::vector<std::string> failed_files;

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
                                              tbl_path.string() + " 2>&1";
                        int result = system(command.c_str());
                        if (result != 0)
                        {
                            fail_count++;
                            failed_files.push_back(schema_name);
                        }
                        else
                        {
                            success_count++;
                        }
                    }
                }
            }

            ProgressDisplay::clear(last_length);

            if (fail_count > 0)
            {
                std::println("\033[33m转换完成，成功: {}，失败: {}\033[0m", success_count, fail_count);
                std::println("\033[33m失败的文件: {}\033[0m", failed_files.size() > 5 
                    ? std::format("{} 等 {} 个文件", failed_files[0], fail_count)
                    : [&]() {
                        std::string list;
                        for (size_t i = 0; i < failed_files.size(); i++) {
                            list += failed_files[i];
                            if (i < failed_files.size() - 1) list += ", ";
                        }
                        return list;
                    }());
            }
            else
            {
                std::println("\033[32m数据表转换完成\033[0m");
            }
            return true;
        }
        catch (const std::exception &e)
        {
            std::println("\033[31m转换过程出错: {} \033[0m", e.what());
            return false;
        }
    }

    bool generateFlatBufferPythonAPI(const std::string &schema_dir, const std::string &output_dir)
    {
        fs::path original_cwd = fs::current_path();

        try
        {
            fs::path abs_schema_dir = fs::absolute(schema_dir);

            if (!fs::exists(abs_schema_dir))
            {
                std::println("\033[31mSchema目录不存在: {}\033[0m", abs_schema_dir.string());
                return false;
            }

            if (!fs::exists(output_dir))
            {
                fs::create_directories(output_dir);
            }

            fs::current_path(output_dir);

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
                        std::println("\033[33m生成 {} 的Python API失败\033[0m", schema_name);
                        result = cmd_result;
                    }
                }
            }

            ProgressDisplay::clear(last_length);

            std::map<std::string, std::vector<std::string>> namespace_files;

            for (const auto &entry : fs::recursive_directory_iterator("."))
            {
                if (entry.is_regular_file() && entry.path().extension() == ".py")
                {
                    std::string dir_name = entry.path().parent_path().filename().string();
                    std::string file_name = entry.path().stem().string();
                    if (file_name.ends_with("Table") && file_name != "__init__")
                    {
                        namespace_files[dir_name].push_back(file_name);
                    }
                }
            }

            for (const auto &[namespace_dir, files] : namespace_files)
            {
                fs::path init_file = fs::path(namespace_dir) / "__init__.py";
                std::ofstream initStream(init_file);
                if (initStream.is_open())
                {
                    initStream << "# Auto-generated FlatBuffer Python API\n";
                    initStream << std::format("# Generated from Eversoul schema files - namespace: {}\n\n", namespace_dir);

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

                fs::current_path(original_cwd);
                return true;
            }
            else
            {
                fs::current_path(original_cwd);
                std::println("\033[31m未能生成任何Python API文件\033[0m");
                return false;
            }
        }
        catch (const std::exception &e)
        {
            try
            {
                fs::current_path(original_cwd);
            }
            catch (...)
            {
            }

            std::println("\033[31m生成FlatBuffer Python API出错: {}\033[0m", e.what());
            return false;
        }
    }
}
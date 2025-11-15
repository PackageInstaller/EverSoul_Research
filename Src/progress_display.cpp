#include "progress_display.hpp"

namespace ProgressDisplay
{
    void update(const std::string &prefix, size_t current, size_t total,
                const std::string &suffix, size_t *last_output_length)
    {
        static size_t internal_last_length = 0;
        size_t &last_length = last_output_length ? *last_output_length : internal_last_length;

        // 清除上一次的输出
        std::cout << "\r" << std::string(last_length, ' ') << "\r";

        std::stringstream output;
        int percentage = static_cast<int>((current * 100.0) / total);

        output << prefix << ": [";
        for (int i = 0; i < 50; i++)
        {
            output << (i < (percentage / 2) ? "=" : " ");
        }
        output << "] " << percentage << "% ("
               << current << "/" << total << ")";

        if (!suffix.empty())
        {
            output << " " << suffix;
        }

        std::string output_str = output.str();
        std::cout << output_str << std::flush;
        last_length = output_str.length();
    }

    void clear(size_t last_output_length)
    {
        std::cout << "\r" << std::string(last_output_length, ' ') << "\r" << std::flush;
    }
}
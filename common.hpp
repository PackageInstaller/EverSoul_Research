#pragma once

#include <iostream>
#include <print>
#include <string>
#include <vector>
#include <cstddef>
#include <map>
#include <regex>
#include <curl/curl.h>
#include <nlohmann/json.hpp>
#include <openssl/evp.h>
#include <openssl/sha.h>
#include <filesystem>
#include <fstream>
#include <cstring>
#include <zlib.h>
#include <cstdint>
#include <format>
#include <future>
#include <mutex>
#include <thread>
#include <algorithm>

namespace fs = std::filesystem;
using json = nlohmann::json;

// 全局常量
const int tableVersion = 0; // 从cdn直接下载的表版本为0, 游戏下载后的表为获取的版本号
const std::string keyMagic = "!@UmWlXo";
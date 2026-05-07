cmake_minimum_required(VERSION 3.31)
project(eversoul)

if(MSVC)
    add_compile_options(/MP)
endif()
set(CMAKE_BINARY_DIR ${CMAKE_SOURCE_DIR}/Build)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR})

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(Threads REQUIRED)
find_package(OpenSSL REQUIRED CONFIG)
find_package(CURL REQUIRED)
find_package(nlohmann_json REQUIRED CONFIG)
find_package(ZLIB REQUIRED)

add_executable(eversoul
    Src/CPP/main.cpp
    Src/CPP/version_manager.cpp
    Src/CPP/table_updater.cpp
    Src/CPP/table_converter.cpp
    Src/CPP/http_client.cpp
    Src/CPP/file_downloader.cpp
    Src/CPP/crypto_utils.cpp
    Src/CPP/progress_display.cpp
)

target_link_libraries(eversoul
    PRIVATE
    OpenSSL::SSL
    OpenSSL::Crypto
    CURL::libcurl
    Threads::Threads
    nlohmann_json::nlohmann_json
    ZLIB::ZLIB
)
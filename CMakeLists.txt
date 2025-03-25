cmake_minimum_required(VERSION 3.31)
project(eversoul)

if(MSVC)
    add_compile_options(/MP)
endif()

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

find_package(Threads REQUIRED)
find_package(OpenSSL REQUIRED CONFIG)
find_package(CURL REQUIRED)
find_package(nlohmann_json REQUIRED CONFIG)
find_package(ZLIB REQUIRED)

add_executable(eversoul
    main.cpp
    utils.cpp
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
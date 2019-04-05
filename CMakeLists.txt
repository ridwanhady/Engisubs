cmake_minimum_required(VERSION 3.10)
 
# Locate GTest
find_package(GTest REQUIRED)
include_directories(${GTEST_INCLUDE_DIRS})
 
# Link runTests with what we want to test and the GTest and pthread library
add_executable(
 AllTest 
 Test_Object.cpp
 Test_Cell.cpp
 Test_Land.cpp
 Test_Coop.cpp
 Test_Barn.cpp
 Test_Grassland.cpp
 Test_Facility.cpp
 )
target_link_libraries(AllTest ${GTEST_LIBRARIES} pthread)
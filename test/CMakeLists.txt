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
 Test_Product.cpp
 Test_FarmProduct.cpp
 Test_Egg.cpp
 Test_ChickenEgg.cpp
 Test_PlatypusEgg.cpp
 Test_PterodactylEgg.cpp
 Test_Meat.cpp
 Test_ChickenMeat.cpp
 Test_PlatypusMeat.cpp
 Test_TRexMeat.cpp
 Test_BisonMeat.cpp
 Test_DogMeat.cpp
 Test_Milk.cpp
 Test_PlatypusMilk.cpp
 Test_BisonMilk.cpp
 Test_Cheese.cpp
 Test_Steak.cpp
 Test_Mayonaise.cpp
 Test_Ekado.cpp
 Test_FarmAnimal.cpp
 Test_EggProducing.cpp
 Test_MilkProducing.cpp
 Test_MeatProducing.cpp
 Test_Bison.cpp
 Test_Dog.cpp
 Test_Chicken.cpp
 Test_Platypus.cpp
 Test_Player.cpp
 )
target_link_libraries(AllTest ${GTEST_LIBRARIES} pthread)
#include "FarmProduct.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(FarmProductTest, AllFarmProductFunctionality){
    FarmProduct testFP;
    ASSERT_EQ(0, testFP.getPrice());
    ASSERT_EQ(EGG, testFP.getFarmProductType(CHICKEN_EGG));
    ASSERT_EQ(MEAT, testFP.getFarmProductType(CHICKEN_MEAT));
    ASSERT_EQ(MILK, testFP.getFarmProductType(BISON_MILK));
    ASSERT_EQ(NOT_FOUND, testFP.getFarmProductType(LAND));
    testFP.initializeFarmProduct("Laba Laba");
    ASSERT_EQ("Laba Laba", testFP.getProducer());
}
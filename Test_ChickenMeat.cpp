#include "ChickenMeat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(ChickenMeatTest, AllFunctionalityofChickenMeat){
    ChickenMeat testCM(20, "Rembo");
    ASSERT_EQ("Rembo", testCM.getProducer());
    ASSERT_EQ(CHICKEN_MEAT, testCM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testCM.getProductType());
    ASSERT_EQ(20, testCM.getPrice());
}
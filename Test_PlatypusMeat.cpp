#include "PlatypusMeat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(PlatypusMeatTest, AllFunctionalityofPlatypusMeat){
    PlatypusMeat testPM(55, "Ferry");
    ASSERT_EQ("Ferry", testPM.getProducer());
    ASSERT_EQ(PLATYPUS_MEAT, testPM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testPM.getProductType());
    ASSERT_EQ(55, testPM.getPrice());
}
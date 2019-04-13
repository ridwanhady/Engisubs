#include "../src/PlatypusMilk.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(PlatypusMilkTest, AllFunctionalityofPlatypusMilk){
    PlatypusMilk testPM(25, "Ferry");
    ASSERT_EQ("Ferry", testPM.getProducer());
    ASSERT_EQ(PLATYPUS_MILK, testPM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testPM.getProductType());
    ASSERT_EQ(25, testPM.getPrice());
}
#include "../include/TRexMeat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(TRexMeatTest, AllFunctionalityofTRexMeat){
    TRexMeat testTM(4000, "King");
    ASSERT_EQ("King", testTM.getProducer());
    ASSERT_EQ(TREX_MEAT, testTM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testTM.getProductType());
    ASSERT_EQ(4000, testTM.getPrice());
}
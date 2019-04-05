#include "../include/BisonMeat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(BisonMeatTest, AllFunctionalityofBisonMeat){
    BisonMeat testBM(75, "Macho");
    ASSERT_EQ("Macho", testBM.getProducer());
    ASSERT_EQ(BISON_MEAT, testBM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testBM.getProductType());
    ASSERT_EQ(75, testBM.getPrice());
}
#include "../include/BisonMilk.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(BisonMilkTest, AllFunctionalityofBisonMilk){
    BisonMilk testBM(45, "Macho");
    ASSERT_EQ("Macho", testBM.getProducer());
    ASSERT_EQ(BISON_MILK, testBM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testBM.getProductType());
    ASSERT_EQ(45, testBM.getPrice());
}
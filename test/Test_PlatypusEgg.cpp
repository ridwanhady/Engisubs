#include "../include/PlatypusEgg.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(PlatypusEggTest, AllFunctionalityofPlatypusEgg){
    PlatypusEgg testPE(40, "Masku");
    ASSERT_EQ("Masku", testPE.getProducer());
    ASSERT_EQ(PLATYPUS_EGG, testPE.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testPE.getProductType());
    ASSERT_EQ(40, testPE.getPrice());
}
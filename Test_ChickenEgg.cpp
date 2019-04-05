#include "ChickenEgg.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(ChickenEggTest, AllFunctionalityofChickenEgg){
    ChickenEgg testCE(30, "Rembo");
    ASSERT_EQ("Rembo", testCE.getProducer());
    ASSERT_EQ(CHICKEN_EGG, testCE.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testCE.getProductType());
    ASSERT_EQ(30, testCE.getPrice());
}
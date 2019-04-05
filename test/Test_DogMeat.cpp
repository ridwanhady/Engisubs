#include "../src/DogMeat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(DogMeatTest, AllFunctionalityofDogMeat){
    DogMeat testDM(40, "Rexus");
    ASSERT_EQ("Rexus", testDM.getProducer());
    ASSERT_EQ(DOG_MEAT, testDM.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testDM.getProductType());
    ASSERT_EQ(40, testDM.getPrice());
}
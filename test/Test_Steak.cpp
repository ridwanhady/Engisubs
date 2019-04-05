#include "../src/Steak.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(SteakTest, AllFunctionalityTest){
    Steak testSteak(150);
    LinkedList<FarmProductType> SteakRecipe = testSteak.getResep();
    ASSERT_EQ(MEAT, SteakRecipe.get(0));
    ASSERT_EQ(MILK, SteakRecipe.get(1));
    ASSERT_EQ(MEAT, testSteak.getResepwithIdx(0));
    ASSERT_EQ(MILK, testSteak.getResepwithIdx(1));
    ASSERT_EQ(150, testSteak.getPrice());
    ASSERT_EQ(STEAK, testSteak.getObjectType());
    ASSERT_EQ(SIDEPRODUCT, testSteak.getProductType());
}
#include "../src/Cheese.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(CheeseTest, AllFunctionalityTest){
    Cheese testCheese(100);
    LinkedList<FarmProductType> CheeseRecipe = testCheese.getResep();
    ASSERT_EQ(MILK, CheeseRecipe.get(0));
    ASSERT_EQ(EGG, CheeseRecipe.get(1));
    ASSERT_EQ(MILK, testCheese.getResepwithIdx(0));
    ASSERT_EQ(EGG, testCheese.getResepwithIdx(1));
    ASSERT_EQ(100, testCheese.getPrice());
    ASSERT_EQ(CHEESE, testCheese.getObjectType());
    ASSERT_EQ(SIDEPRODUCT, testCheese.getProductType());
}
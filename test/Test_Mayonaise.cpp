#include "../src/Mayonaise.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(MayonaiseTest, AllFunctionalityTest){
    Mayonaise testMayonaise(50);
    LinkedList<FarmProductType> MayonaiseRecipe = testMayonaise.getResep();
    ASSERT_EQ(EGG, MayonaiseRecipe.get(0));
    ASSERT_EQ(MILK, MayonaiseRecipe.get(1));
    ASSERT_EQ(EGG, testMayonaise.getResepwithIdx(0));
    ASSERT_EQ(MILK, testMayonaise.getResepwithIdx(1));
    ASSERT_EQ(50, testMayonaise.getPrice());
    ASSERT_EQ(MAYONAISE, testMayonaise.getObjectType());
    ASSERT_EQ(SIDEPRODUCT, testMayonaise.getProductType());
}
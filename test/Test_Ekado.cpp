#include "../src/Ekado.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(EkadoTest, AllFunctionalityTest){
    Ekado testEkado(10);
    LinkedList<FarmProductType> EkadoRecipe = testEkado.getResep();
    ASSERT_EQ(EGG, EkadoRecipe.get(0));
    ASSERT_EQ(MEAT, EkadoRecipe.get(1));
    ASSERT_EQ(EGG, testEkado.getResepwithIdx(0));
    ASSERT_EQ(MEAT, testEkado.getResepwithIdx(1));
    ASSERT_EQ(10, testEkado.getPrice());
    ASSERT_EQ(EKADO, testEkado.getObjectType());
    ASSERT_EQ(SIDEPRODUCT, testEkado.getProductType());
}
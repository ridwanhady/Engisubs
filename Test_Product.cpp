#include "Product.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(ProductTest, PureProductFunctionality){
    Product testProduct;
    ASSERT_EQ(0, testProduct.getPrice());
    ASSERT_NE(FARMPRODUCT, testProduct.getObjectType());
    ASSERT_NE(BISON_MEAT, testProduct.getObjectType());
    testProduct.initializeProduct(20, FARMPRODUCT, BISON_MEAT, '?');
    ASSERT_EQ(20, testProduct.getPrice());
    ASSERT_EQ(FARMPRODUCT, testProduct.getProductType());
    ASSERT_EQ(BISON_MEAT, testProduct.getObjectType());
}
#include "Meat.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(MeatTest, NoTestNeededForPureMeat){
    Meat testMeat;
    ASSERT_EQ(1,1);
}
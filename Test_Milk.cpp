#include "Milk.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(MilkTest, NoTestNeededForPureMilk){
    Milk testMilk;
    ASSERT_EQ(1,1);
}
#include "Cell.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(CellTest, PositionTest) { 
    pair<int,int> expect = {1,1};
    Cell test(expect);
    pair<int,int> newExpect = {2,2};
    ASSERT_EQ(expect, test.getPosition());
    test.setPosition(newExpect);
    ASSERT_EQ(newExpect, test.getPosition());
    ASSERT_FALSE(test.isWalkable());
}
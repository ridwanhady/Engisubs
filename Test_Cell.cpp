#include "Cell.cpp"
#include <gtest/gtest.h>
#include "cstring"

using namespace std;

class DummyDerrived: public Cell{
    public:
        DummyDerrived(std::pair<int,int> pos) : Cell(pos){
        }
        bool isWalkable(){
            return true;
        }
};

TEST(CellTest, PositionTest) { 
    pair<int,int> expect = {1,1};
    DummyDerrived test(expect);
    pair<int,int> newExpect = {2,2};
    ASSERT_EQ(expect, test.getPosition());
    test.setPosition(newExpect);
    ASSERT_EQ(newExpect, test.getPosition());
    ASSERT_TRUE(test.isWalkable());
}
#include "Truck.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(TruckTest, PositionTest){
    pair<int,int> expect = {1,2};
    Truck testTruck(expect);
    ASSERT_EQ(expect, testTruck.getPosition());
    ASSERT_FALSE(testTruck.isWalkable());
}

TEST(TruckTest, TruckUsable){
    pair<int,int> expect = {1,3};
    Truck testTruck2(expect);
    ASSERT_TRUE(testTruck2.isUsable());
}
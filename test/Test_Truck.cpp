#include "../include/Truck.cpp"
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
    pair<int,int> manPos = {2,3};
    ASSERT_TRUE(testTruck2.isUsable());
    testTruck2.interact(NULL);
    ASSERT_FALSE(testTruck2.isUsable());
    ASSERT_EQ(10, testTruck2.getNotUsableTurns());
}
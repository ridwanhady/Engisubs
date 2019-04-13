#include "../src/Facility.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(FacilityTest, PositionTest){
    pair<int,int> expect = {4,4};
    Facility testFacility(expect);
    ASSERT_EQ(expect, testFacility.getPosition());
    ASSERT_FALSE(testFacility.isWalkable());
}
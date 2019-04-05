#include "../include/Facility.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(FacilityTest, PositionTest){
    pair<int,int> expect = {4,4};
    Facility testFacility(expect);
    ASSERT_EQ(expect, testFacility.getPosition());
    cout << "Facility tidak bisa dilangkahi" << endl;
    ASSERT_FALSE(testFacility.isWalkable());
}
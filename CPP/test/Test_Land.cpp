#include "../src/Land.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(LandTest, AllFunctionalityofLand){
    pair<int,int> expect = {3,3};
    Land testLand(expect, true, GRASSLAND);
    testing::internal::CaptureStdout();
    testLand.render();
    string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("#", output);
    ASSERT_TRUE(testLand.isWalkable());
    ASSERT_TRUE(testLand.isGrown());
    ASSERT_FALSE(testLand.isOccupied());
    ASSERT_EQ(NULL, testLand.getObjectHere());
    Object object;
    testLand.setObjectHere(&object);
    ASSERT_TRUE(testLand.isOccupied());
    ASSERT_EQ(&object, testLand.getObjectHere());
    testLand.ungrow();
    ASSERT_FALSE(testLand.isGrown());
    testing::internal::CaptureStdout();
    testLand.render();
    string output2 = testing::internal::GetCapturedStdout();
    ASSERT_EQ("?", output2);
}
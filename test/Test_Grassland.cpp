#include "../src/Grassland.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(GrasslandTest, AllFunctionalityofGrassland){
    pair<int,int> expect = {3,3};
    Grassland testGrassland(expect, true);
    testing::internal::CaptureStdout();
    testGrassland.render();
    string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("#", output);
    ASSERT_TRUE(testGrassland.isWalkable());
    ASSERT_TRUE(testGrassland.isGrown());
    ASSERT_FALSE(testGrassland.isOccupied());
    ASSERT_EQ(NULL, testGrassland.getObjectHere());
    Object object;
    testGrassland.setObjectHere(&object);
    ASSERT_TRUE(testGrassland.isOccupied());
    ASSERT_EQ(&object, testGrassland.getObjectHere());
    testGrassland.ungrow();
    ASSERT_FALSE(testGrassland.isGrown());
    testing::internal::CaptureStdout();
    testGrassland.render();
    string output2 = testing::internal::GetCapturedStdout();
    ASSERT_EQ("-", output2);
}
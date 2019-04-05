#include "../src/Coop.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(CoopTest, AllFunctionalityofCoop){
    pair<int,int> expect = {3,3};
    Coop testCoop(expect, true);
    testing::internal::CaptureStdout();
    testCoop.render();
    string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("*", output);
    ASSERT_TRUE(testCoop.isWalkable());
    ASSERT_TRUE(testCoop.isGrown());
    ASSERT_FALSE(testCoop.isOccupied());
    ASSERT_EQ(NULL, testCoop.getObjectHere());
    Object object;
    testCoop.setObjectHere(&object);
    ASSERT_TRUE(testCoop.isOccupied());
    ASSERT_EQ(&object, testCoop.getObjectHere());
    testCoop.ungrow();
    ASSERT_FALSE(testCoop.isGrown());
    testing::internal::CaptureStdout();
    testCoop.render();
    string output2 = testing::internal::GetCapturedStdout();
    ASSERT_EQ("o", output2);
}
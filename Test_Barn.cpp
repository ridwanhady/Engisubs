#include "Barn.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(BarnTest, AllFunctionalityofBarn){
    pair<int,int> expect = {3,3};
    Barn testBarn(expect, true);
    testing::internal::CaptureStdout();
    testBarn.render();
    string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("@", output);
    ASSERT_TRUE(testBarn.isWalkable());
    ASSERT_TRUE(testBarn.isGrown());
    ASSERT_FALSE(testBarn.isOccupied());
    ASSERT_EQ(NULL, testBarn.getObjectHere());
    Object object;
    testBarn.setObjectHere(&object);
    ASSERT_TRUE(testBarn.isOccupied());
    ASSERT_EQ(&object, testBarn.getObjectHere());
    testBarn.ungrow();
    ASSERT_FALSE(testBarn.isGrown());
    testing::internal::CaptureStdout();
    testBarn.render();
    string output2 = testing::internal::GetCapturedStdout();
    ASSERT_EQ("x", output2);
}
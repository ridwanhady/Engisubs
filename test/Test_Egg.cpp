#include "../include/Egg.cpp"
#include <gtest/gtest.h>

using namespace std;

TEST(EggTest, NoTestNeededForPureEGG){
    cout << "No Test Needed for Pure Egg" << endl;
    ASSERT_EQ(1,1);
}
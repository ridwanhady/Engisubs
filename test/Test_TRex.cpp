#include "../src/TRex.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> TRexPos = {1,1};
Land landPosTT(TRexPos, true, GRASSLAND);
TRex Mario(TRexPos, "Mario", &landPosTT);
pair<int,int> playerPosTT = {1,2};
Player pemainTT("Joko", 20, 100, playerPosTT,NULL);

TEST(TRexTest, ItCanTalk){
    testing::internal::CaptureStdout();
    Mario.talk();
    std::string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("Mario: Reeeeeeeeeek!\n", output);
}

TEST(TRexTest, ProduceMeat){
    Mario.produceMeat(*(&pemainTT));
    ASSERT_EQ(1, pemainTT.getInventory().size());
}
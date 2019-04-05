#include "../src/Dog.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> dogPos = {1,1};
Land landPosTD(dogPos, true, GRASSLAND);
Dog rexus(dogPos, "Rexus", &landPosTD);
pair<int,int> playerPosTD = {1,2};
Player pemainTD("Joko", 20, 100, playerPosTD);

TEST(DogTest, ItCanTalk){
    testing::internal::CaptureStdout();
    rexus.talk();
    std::string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("Rexus: Guk Guk Ruyuk!\n", output);
}

TEST(DogTest, ProduceMeat){
    rexus.produceMeat(*(&pemainTD));
    ASSERT_EQ(1, pemainTD.getInventory().size());
}
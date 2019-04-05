#include "../src/Bison.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> pos = {1,1};
Land landPos(pos, true, GRASSLAND);
Bison bernard(pos, "Bernard", &landPos);
pair<int,int> playerPosTB = {1,2};
Player pemainTB("Joko", 20, 100, playerPosTB);

TEST(BisonTest, ItCanTalk){
    testing::internal::CaptureStdout();
    bernard.talk();
    std::string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("Bernard: Mooo Ahahahah!\n", output);
}

TEST(BisonTest, ProduceMilk){
    bernard.eat();
    bernard.interact(&pemainTB);
    ASSERT_EQ(1,pemainTB.getInventory().size());
}

TEST(BisonTest, ProduceMeat){
    bernard.produceMeat(*(&pemainTB));
    ASSERT_EQ(2, pemainTB.getInventory().size());
}
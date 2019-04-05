#include "../src/Platypus.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> posTP = {4,4};
Land landposTP(posTP, true, GRASSLAND);
Platypus ferry(posTP, "ferry", &landposTP);
pair<int,int> playerposTPTB = {3,4};

Player pemainTP("Joko", 20, 100, playerposTPTB, NULL);

TEST(PlatypusTest, ItCanTalk){
    testing::internal::CaptureStdout();
    ferry.talk();
    std::string ferryTalk = testing::internal::GetCapturedStdout();
    ASSERT_EQ("ferry: Eyy, what the hell?\n", ferryTalk);
}

TEST(PlatypusTest, ProduceEggtandMilk){
    ferry.eat();
    ferry.interact(&pemainTP);
}

TEST(PlatypusTest, ProduceMeat){
    ferry.produceMeat(*(&pemainTP));
    ASSERT_EQ(3,pemainTP.getInventory().size());
}
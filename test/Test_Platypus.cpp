#include "../src/Platypus.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> posTP = {4,4};
Land landposTP(posTP, true, GRASSLAND);
Platypus Ferry(posTP, "Ferry", &landposTP);
pair<int,int> playerposTPTB = {3,4};

Player pemainTP("Joko", 20, 100, playerposTPTB);

TEST(PlatypusTest, ProduceEggtandMilk){
    Ferry.eat();
    Ferry.interact(&pemainTP);
    ASSERT_EQ(3,pemainTP.getInventory().size());
}

TEST(PlatypusTest, ProduceMeat){
    Ferry.produceMeat(*(&pemainTP));
    ASSERT_EQ(1, pemainTP.getInventory().size());
}


TEST(PlatypusTest, ItCanTalk){
    testing::internal::CaptureStdout();
    Ferry.talk();
    std::string FerryTalk = testing::internal::GetCapturedStdout();
    ASSERT_EQ("Ferry: Eyy, what the hell?\n", FerryTalk);
}

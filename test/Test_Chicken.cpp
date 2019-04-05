#include "../src/Chicken.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

pair<int,int> posTC = {3,3};
Land landposTC(posTC, true, GRASSLAND);
Chicken saurus(posTC, "Saurus", &landposTC);
pair<int,int> playerposTCTB = {3,4};

Player pemainTC("Joko", 20, 100, playerposTCTB);



TEST(ChickenTest, ProduceEgg){
    saurus.eat();
    saurus.interact(&pemainTC);
    ASSERT_EQ(1,pemainTC.getInventory().size());
}

TEST(ChickenTest, ItCanTalk){
    testing::internal::CaptureStdout();
    saurus.talk();
    std::string saurusTalk = testing::internal::GetCapturedStdout();
    ASSERT_EQ("Saurus: Petok Petok\n", saurusTalk);
}

TEST(ChickenTest, ProduceMeat){
    saurus.produceMeat(*(&pemainTC));
    ASSERT_EQ(2, pemainTC.getInventory().size());
}
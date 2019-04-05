#include "../src/Player.cpp"
#include <gtest/gtest.h>

using namespace std;

pair<int,int> playerPos = {0,0};
Player pemain("Joko", 100, 2000, playerPos);
TEST(PlayerTest, BasicTest){
    ASSERT_EQ("Joko", pemain.getName());
    ASSERT_EQ(100, pemain.getWater());
    ASSERT_EQ(2000, pemain.getUang());
    ASSERT_EQ(0, pemain.getInventory().size());
    ASSERT_EQ(playerPos, pemain.getPosition());
}

TEST(PlayerTest, SetTest){
    pemain.setName("Naruto");
    ASSERT_EQ("Naruto", pemain.getName());
    pemain.setWater(150);
    ASSERT_EQ(150, pemain.getWater());
    pemain.setUang(2500);
    ASSERT_EQ(2500, pemain.getUang());
    pemain.addInventory(NULL);
    ASSERT_EQ(1, pemain.getInventory().size());
    pair<int,int> newPos = {1,0};
    pemain.setPosition(newPos);
    ASSERT_EQ(newPos, pemain.getPosition());
}
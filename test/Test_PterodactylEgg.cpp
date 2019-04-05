#include "../include/PterodactylEgg.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

TEST(PterodactylEggTest, AllFunctionalityofPteradactylEgg){
    PterodactylEgg testPE(500, "oldie");
    ASSERT_EQ("oldie", testPE.getProducer());
    ASSERT_EQ(PTERODACTYL_EGG, testPE.getObjectType());
    ASSERT_EQ(FARMPRODUCT, testPE.getProductType());
    ASSERT_EQ(500, testPE.getPrice());
}
#include "Object.cpp"
#include "Player.cpp"
#include "Land.cpp"
#include "Cell.cpp"
#include "FarmAnimal.cpp"
#include <gtest/gtest.h>
#include "cstring"

TEST(ObjectTest, ReturningObjectSymbol) 
    { 
        Player testPlayer("Joko", 20, 20, {0,0});
        testing::internal::CaptureStdout();
        testPlayer.render();
        std::string output = testing::internal::GetCapturedStdout();
        ASSERT_EQ("P", output);
    }
 
//TEST(SquareRootTest, NegativeNos) 
//    {
//    ASSERT_EQ(-1.0, squareRoot(-15.0));
//    ASSERT_EQ(-1.0, squareRoot(-0.2));
//    }
 
int main(int argc, char **argv) 
    {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
    }
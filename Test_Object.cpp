#include "Object.cpp"
#include <gtest/gtest.h>
#include "cstring"

using namespace std;

class DummyDerrived: public Object{
    public:
        DummyDerrived() : Object('D'){
            objectType = PLAYER;
        }
};

TEST(ObjectTest, FunctionalityRender) 
    { 
        DummyDerrived test;
        testing::internal::CaptureStdout();
        test.render();
        std::string output = testing::internal::GetCapturedStdout();
        ASSERT_EQ("D", output);
    }

TEST(ObjectTest, ReturningObjectType) 
    { 
        DummyDerrived test;
        ASSERT_EQ(PLAYER, test.getObjectType());
    }

 
int main(int argc, char **argv) 
    {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
    }
#include "../src/Object.cpp"
#include <gtest/gtest.h>
#include <string>

using namespace std;

class DummyDerrived: public Object{
    public:
        DummyDerrived() : Object('D'){
            objectType = PLAYER;
        }
        void interact(Player* _p){
            cout<<"Im just a Dummy";
        }
};

TEST(ObjectTest, FunctionalityRender) { 
    DummyDerrived test;
    testing::internal::CaptureStdout();
    test.render();
    string output = testing::internal::GetCapturedStdout();
    ASSERT_EQ("D", output);
}

TEST(ObjectTest, ReturningObjectType) { 
    DummyDerrived test;
    ASSERT_EQ(PLAYER, test.getObjectType());
}

TEST(ObjectTest, OverrideInteract){
    DummyDerrived test;
    testing::internal::CaptureStdout();
    test.interact(NULL);
    string output = testing::internal::GetCapturedStdout();    
    ASSERT_EQ("Im just a Dummy", output);
}
 
int main(int argc, char **argv) {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
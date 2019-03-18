#ifndef _CHEESE_H_
#define _CHEESE_H_
#include "SideProduct.hpp"

class Cheese : public SideProduct{
    private:
        //ATTRIBUTE NEEDED
        static int totalCheese;
    public:
        //METHOD NEEDED
        Cheese(Susu, Susu);
};

#endif
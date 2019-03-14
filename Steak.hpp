#ifndef _STEAK_H_
#define _STEAK_H_

#include "SideProduct.hpp"

class Steak : public SideProduct {
    private:
        //ATTRIBUTE NEEDED
        static int totalSteak;
    public:
        //METHODS NEEDED
        Steak(Meat, Meat);
};

#endif
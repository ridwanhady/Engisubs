#ifndef _MAYONAISE_H_
#define _MAYONAISE_H_

#include "SideProduct.hpp"

class Mayonaise : public SideProduct {
    private:
        //ATTRIBUTE NEEDED
        static int totalMayonaise;
    public:
        //METHODS NEEDED
        Mayonaise(Egg, Egg);
};

#endif
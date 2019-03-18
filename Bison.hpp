#ifndef _BISON_H_
#define _BISON_H_
#include "FarmAnimal.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"

class Bison : public FarmAnimal {
    private:

    public:
        BisonMilk produceMilk();
        BisonMeat kill();
};

#endif
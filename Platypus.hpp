#ifndef _PLATYPUS_H_
#define _PLATYPUS_H_
#include "FarmAnimal.hpp"
#include "PlatypusEgg.hpp"
#include "PlatypusMeat.hpp"
#include "PlatypusMilk.hpp"

class Platypus : public FarmAnimal {
    private:

    public:
        PlatypusMilk produceMilk();
        PlatypusEgg produceEgg();
        PlatypusMeat kill();
};

#endif
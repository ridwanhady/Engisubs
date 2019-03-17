#ifndef _CHICKEN_H_
#define _CHICKEN_H_
#include "FarmAnimal.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"


class Chicken : public FarmAnimal {
    private:
    public:
        ChickenEgg produceEgg();
        ChickenMeat kill();
};

#endif
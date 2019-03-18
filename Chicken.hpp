#ifndef _CHICKEN_H_
#define _CHICKEN_H_

#include "FarmAnimal.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"
#include <string>

class Chicken : public EggProducing, MeatProducing {
    private:

    public:
        // ctor
        Chicken();

        // ctor dengan parameter
        Chicken(const string _name);

        // getter
        setName( _name);

        // setter
        getName();

};

#endif

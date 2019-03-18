#ifndef _CHICKEN_H_
#define _CHICKEN_H_

#include "EggProducing.hpp"
#include "MeatProducing.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"
#include <string>

class Chicken : public EggProducing, MeatProducing {
    private:

    public:
        // ctor dengan parameter
        Chicken(const string _name);
};

#endif

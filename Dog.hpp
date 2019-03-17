#ifndef _DOG_H_
#define _DOG_H_
#include "FarmAnimal.hpp"
#include "DogMeat.hpp"

class Dog : public FarmAnimal {
    private:

    public:
        /* Method kill will produce its Animal Meat
         * if applied on Dog, it will produce Dog Meat.
        */
        DogMeat kill();
};

#endif
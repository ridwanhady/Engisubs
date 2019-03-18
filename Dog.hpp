#ifndef _DOG_H_
#define _DOG_H_

#include "DogMeat.hpp"
#include "MeatProducing.hpp"
#include <string>

class Dog : public MeatProducing {
    private:
    public:

        // ctor dengan parameter
        Dog(const string _name);
};

#endif

#ifndef _DOG_H_
#define _DOG_H_

#include "FarmAnimal.hpp"
#include "DogMeat.hpp"
#include <string>

class Dog : public FarmAnimal {
    private:
    string name;
    
    public:
        // ctor
        Dog();    
        
        // ctor dengan parameter
        Dog(const string _name);
    
        // getter
        setName( _name);
    
        // setter
        getName(); 
    
        /* Method kill will produce its Animal Meat
         * if applied on Dog, it will produce Dog Meat.
        */
        DogMeat kill();
};

#endif

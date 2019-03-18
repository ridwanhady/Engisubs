#ifndef _CHICKEN_H_
#define _CHICKEN_H_

#include "FarmAnimal.hpp"
#include "ChickenEgg.hpp"
#include "ChickenMeat.hpp"
#include <string>

class Chicken : public FarmAnimal {
    private:
        string name;
    public:
        // ctor
        Chicken();
    
        // ctor dengan parameter
        Chicken(const string _name);
        
        // getter
        setName(string _name);
    
        // setter
        getName(); 
    
        // produksi
        ChickenEgg produceEgg();
        ChickenMeat kill();
};

#endif

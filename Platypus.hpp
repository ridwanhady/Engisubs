#ifndef _PLATYPUS_H_
#define _PLATYPUS_H_

#include "FarmAnimal.hpp"
#include "PlatypusEgg.hpp"
#include "PlatypusMeat.hpp"
#include "PlatypusMilk.hpp"
#include <string>

class Platypus : public FarmAnimal {
    private:
        string name;
    
    public:
        // ctor
        Platypus();
        
        // ctor dengan parameter
        Platypus(const string _name);
    
        // getter
        setName( _name);
    
        // setter
        getName(); 
    
        //produksi
        PlatypusMilk produceMilk();
        PlatypusEgg produceEgg();
        PlatypusMeat kill();
};

#endif

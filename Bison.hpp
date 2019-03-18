#ifndef _BISON_H_
#define _BISON_H_

#include "FarmAnimal.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"
#include <string>

class Bison : public FarmAnimal {
    private:
        string name;
    
    public:
        // ctor
        Bison();
        
        // ctor dengan parameter
        Bison(const string _name);
    
        // getter
        setName( _name);
    
        // setter
        getName();    
    
        // produk
        BisonMilk produceMilk();
        BisonMeat kill();
};

#endif

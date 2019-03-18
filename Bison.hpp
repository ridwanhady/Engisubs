#ifndef _BISON_H_
#define _BISON_H_

#include "FarmAnimal.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"
#include <string>

class Bison : public MeatProducing, MilkProducing {
    private:
        string name;
    
    public:
<<<<<<< HEAD

=======
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
>>>>>>> 22fadd4dd738f026404b7d04dbba94f55cc83530
};

#endif

#ifndef _TREX_H_
#define _TREX_H_

#include "FarmAnimal.hpp"
#include "TRexMeat.hpp"
#include <string>

class Trex : public FarmAnimal {
    private:
        string name;
    
    public:
        // ctor
        Trex();
        
        //ctor dengan parameter
        Trex(const string _name);    
    
        // getter
        setName( _name);
    
        // setter
        getName(); 
    
        //produksi
        TrexMeat kill();
};

#endif

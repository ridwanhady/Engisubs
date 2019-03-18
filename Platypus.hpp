#ifndef _PLATYPUS_H_
#define _PLATYPUS_H_

#include "PlatypusEgg.hpp"
#include "PlatypusMeat.hpp"
#include "PlatypusMilk.hpp"
#include "MilkProducing.hpp"
#include "EggProducing.hpp"
#include <string>

class Platypus : public MilkProducing, EggProducing {
    private:
        string name;
    
    public:
        // ctor dengan parameter
        Platypus(const string _name);
};

#endif

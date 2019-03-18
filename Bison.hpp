#ifndef _BISON_H_
#define _BISON_H_

#include "MeatProducing.hpp"
#include "MilkProducing.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"
#include <string>

class Bison : public MeatProducing, MilkProducing {
    private:
    
    public:
        // ctor dengan parameter nama
        Bison(const string _name);
};

#endif

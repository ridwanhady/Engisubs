#ifndef _TREX_H_
#define _TREX_H_

#include "MeatProducing.hpp"
#include "TRexMeat.hpp"
#include <string>

class TRex : public MeatProducing {
    private:
        string name;

    public:
        //ctor dengan parameter
        Trex(const string _name);
};

#endif

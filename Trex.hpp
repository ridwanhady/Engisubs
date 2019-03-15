#ifndef _TREX_H_
#define _TREX_H_
#include "FarmAnimal.hpp"
#include "TRexMeat.hpp"

class Trex : public FarmAnimal {
    private:

    public:
        TrexMeat kill();
};

#endif
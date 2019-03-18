#ifndef _MILKPRODUCING_HPP_
#define _MILKPRODUCING_HPP_

#include "FarmAnimal.hpp"

class MilkProducing : FarmAnimal {
    protected:
        Milk M;
    public:
        //Constructor
        MilkProducing(Milk _milk);

        //Memproduksi susu. Menerima reference ke player.
        virtual void produceMilk(Player& _player) = 0;
};
#endif

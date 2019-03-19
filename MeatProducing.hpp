#ifndef _MEATPRODUCING_HPP_
#define _MEATPRODUCING_HPP_

#include "FarmAnimal.hpp"

class MeatProducing: public FarmAnimal {
    protected:
        Meat M;
    public:
        //Constructor
        MeatProducing(Meat _meat);

        //Hewan akan mati saat memproduksi daging. Menerima
        //reference ke player.
        virtual void produceMeat(Player& _player) = 0;
};
#endif

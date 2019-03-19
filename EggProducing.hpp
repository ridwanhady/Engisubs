#ifndef _EGGPRODUCING_HPP_
#define _EGGPRODUCING_HPP_

#include "FarmAnimal.hpp"

class EggProducing : public FarmAnimal {
    private:
        Egg E;
    public:
        //Constructor
        EggProducing(Egg _egg);

        //Memproduksi telur. Menerima reference ke player.
        virtual void produceEgg(Player& _player) = 0;
};
#endif

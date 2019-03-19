#ifndef _EGGPRODUCING_HPP_
#define _EGGPRODUCING_HPP_

#include "FarmAnimal.hpp"
#include "Egg.hpp"
#include "Player.hpp"

class EggProducing : public FarmAnimal {
    private:
        Egg& E;
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari FarmAnimal.
        */
        EggProducing(pair <int,int> _position, string _name, Egg& _egg);

        /*
        Method untuk memproduksi telur. Menerima reference ke player.
        */
        virtual void produceEgg(Player& _player) = 0;
};
#endif

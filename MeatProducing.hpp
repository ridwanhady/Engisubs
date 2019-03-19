#ifndef _MEATPRODUCING_HPP_
#define _MEATPRODUCING_HPP_

#include "FarmAnimal.hpp"
#include "Meat.hpp"

class MeatProducing: public FarmAnimal {
    protected:
        Meat M;
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari FarmAnimal.
        */
        MeatProducing(pair<int,int> _position, string _name, Meat _meat);

        /*
        Method virtual. Hewan akan mati saat memproduksi daging.
        Menerima reference ke player
        */
        virtual void produceMeat(Player& _player) = 0;
};
#endif

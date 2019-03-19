#ifndef _MILKPRODUCING_HPP_
#define _MILKPRODUCING_HPP_

#include "FarmAnimal.hpp"
#include "Milk.hpp"
#include "Player.hpp"

class MilkProducing : public FarmAnimal {
    protected:
        Milk* M;
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari FarmAnimal.
        */
        MilkProducing(pair<int,int> _position, string _name, Milk* _milk);

        /*
        Method virtual. Memproduksi susu. Menerima reference ke player.
        */
        virtual void produceMilk(Player& _player) = 0;
};
#endif

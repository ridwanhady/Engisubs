#ifndef _MEATPRODUCING_HPP_
#define _MEATPRODUCING_HPP_

#include "FarmAnimal.hpp"
#include "Meat.hpp"
#include "Player.hpp"

class MeatProducing: public virtual FarmAnimal {
    protected:
        Meat* meat;
    public:
        /*
        Constructor yang menerima parameter position, name, egg.
        Parameter diturunkan dari FarmAnimal.
        */
        MeatProducing();

        void initializeMeatProducing(Meat* _meat);

        /*Method virtual. 
        Hewan akan mati saat memproduksi daging.
        Menerima reference ke player
        */
        virtual void produceMeat(Player& _player);

        /*
        Desktruktor
        */
        ~MeatProducing();
};
#endif

#ifndef _DOG_H_
#define _DOG_H_

#include "Land.hpp"
#include "DogMeat.hpp"
#include "MeatProducing.hpp"
#include <string>

#define HARGA_DAGING_ANJING 40

class Dog : public MeatProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat.
        Parameter diturunkan dari MeatProducing.
        */
        Dog(pair<int,int> _position, string _name, Land* _landPos);

        /*
        Method untuk mengetahui apakah Dog sudah mati
        karena dagingnya diproduksi. Method diturunkan dari
        MeatProducing
        */
        void produceMeat(Player& _player);

        bool isKillable();

        void eat();

        void talk();
};

#endif

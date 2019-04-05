#ifndef _PLATYPUS_H_
#define _PLATYPUS_H_

#include "Land.hpp"
#include "PlatypusEgg.hpp"
#include "PlatypusMeat.hpp"
#include "PlatypusMilk.hpp"
#include "MilkProducing.hpp"
#include "EggProducing.hpp"
#include "MeatProducing.hpp"
#include "Player.hpp"
#include <string>

#define HARGA_TELUR_PLATYPUS 10
#define HARGA_SUSU_PLATYPUS 15
#define HARGA_DAGING_PLATYPUS 50

class Platypus : public MilkProducing, EggProducing, MeatProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat, dan milk serta egg
        Parameter diturunkan dari MeatProducing dan MilkProducing dan EggProducing
        */
        Platypus(pair<int,int> _position, string _name, Land* _landPos);

        /*
        Method untuk memproduksi daging Platypus. Method diturunkan dari
        MeatProducing
        */
        void produceMeat(Player& _player);

        /*
        Method untuk memproduksi susu Platypus. Method diturunkan dari
        MilkProducing
        */
        void produceMilk(Player& _player);

        /*
        Method untuk memproduksi egg Platypus. Method diturunkan dari
        EggProducing
        */
        void produceEgg(Player& _player);

        bool isKillable();

        void eat();

        void talk();

        void interact(Player* _p);
};

#endif

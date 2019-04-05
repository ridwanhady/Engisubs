#ifndef _BISON_H_
#define _BISON_H_

#include "Land.hpp"
#include "MeatProducing.hpp"
#include "MilkProducing.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"
#include <string>

#define HARGA_SUSU_BISON 30
#define HARGA_DAGING_BISON 100

class Bison : public MeatProducing, MilkProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat, dan milk
        Parameter diturunkan dari MeatProducing dan MilkProducing.
        */
        Bison(pair<int,int> _position, string _name, Land* _landPos);

        void produceMeat(Player& _player);

        void produceMilk(Player& _player);

        bool isKillable();

        void eat();

        void talk();

        void interact(Player* _p);
};

#endif

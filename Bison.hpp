#ifndef _BISON_H_
#define _BISON_H_

#include "MeatProducing.hpp"
#include "MilkProducing.hpp"
#include "BisonMeat.hpp"
#include "BisonMilk.hpp"
#include <string>

class Bison : public MeatProducing, MilkProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat, dan milk
        Parameter diturunkan dari MeatProducing dan MilkProducing.
        */
        Bison(pair<int,int> _position, string _name, Meat* _meat, Milk* _milk);

        /*
        Method untuk mengetahui apakah Bison sudah mati
        karena dagingnya diproduksi. Method diturunkan dari
        MeatProducing
        */
        void produceMeat(Player& _player);

        /*
        Method untuk mengetahui apakah susunya sudah diproduksi. Method diturunkan dari
        MilkProducing
        */
        void produceMilk(Player& _player);
    };

#endif

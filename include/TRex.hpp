#ifndef _TREX_H_
#define _TREX_H_

#include "Land.hpp"
#include "MeatProducing.hpp"
#include "TRexMeat.hpp"
#include "Meat.hpp"
#include <string>

#define HARGA_DAGING_TREX 120

class TRex : public MeatProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat.
        Parameter diturunkan dari MeatProducing.
        */
        TRex(pair<int,int> _position, string _name, Land* _landPos);

        /*
        Method untuk memproduksi meat dan membuat hewan mati.
        */
        void produceMeat(Player& _player);

        void eat();

        void talk();

};

#endif

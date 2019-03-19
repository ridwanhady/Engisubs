#ifndef _TREX_H_
#define _TREX_H_

#include "MeatProducing.hpp"
#include "TRexMeat.hpp"
#include "Meat.hpp"
#include <string>

class TRex : public MeatProducing {
    public:
        /*
        Constructor yang menerima parameter position, name, meat.
        Parameter diturunkan dari MeatProducing.
        */
        TRex(pair<int,int> _position, string _name, Meat* _meat);

        /*
        Method untuk memproduksi meat dan membuat hewan mati.
        */
        void produceMeat(Player& _player);

};

#endif

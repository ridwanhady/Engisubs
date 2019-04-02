#ifndef _PLATYPUSMEAT_HPP_
#define _PLATYPUSMEAT_HPP_

#include "Meat.hpp"

//Kelas ini merepresentasikan produk daging Platipus.
class PlatypusMeat : public Meat {
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        PlatypusMeat(int _price, string _producer);
};

#endif

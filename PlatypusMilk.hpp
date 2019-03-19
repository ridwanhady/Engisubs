#ifndef _PLATYPUSMILK_HPP_
#define _PLATYPUSMILK_HPP_

#include "Milk.hpp"

//Kelas ini merepresentasikan produk susu Platipus.
class PlatypusMilk : public Milk {
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        PlatypusMilk(int _price, string producer);
};

#endif

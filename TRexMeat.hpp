#ifndef _TREXMEAT_HPP_
#define _TREXMEAT_HPP_
#include "Meat.hpp"

//Kelas ini merepresentasikan produk daging TRex.
class TRexMeat : public Meat{
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        TRexMeat(int _price, string producer);
};

#endif

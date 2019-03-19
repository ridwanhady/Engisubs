#ifndef _MEAT_HPP_
#define _MEAT_HPP_

#include "FarmProduct.hpp"

//Kelas ini merepresentasikan produk daging.
class Meat : public FarmProduct{
    public:
        //Constructor menerima harga, dan menginisialisasi producer untuk superclass
        Meat(int _price, string producer);
};

#endif

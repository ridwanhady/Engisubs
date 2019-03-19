#ifndef _MILK_HPP_
#define _MILK_HPP_

#include "FarmProduct.hpp"

//Kelas ini merepresentasikan produk susu.
class Milk : public FarmProduct {
    public:
        //Constructor menerima harga, dan menginisialisasi producer untuk superclass
        Milk(int _price, string producer);
};

#endif

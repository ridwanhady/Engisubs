#ifndef _EGG_HPP_
#define _EGG_HPP_

#include "FarmProduct.hpp"
using namespace std;

//Kelas ini merepresentasikan produk telur.
class Egg : public FarmProduct{
    public:
        //Constructor menerima harga, dan menginisialisasi producer untuk superclass.
        Egg(int _price, string producer);
};

#endif

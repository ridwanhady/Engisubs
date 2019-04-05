#ifndef _CHICKENMEAT_HPP_
#define _CHICKENMEAT_HPP_

#include "Meat.hpp"

//Kelas ini merepresentasikan produk daging Ayam.
class ChickenMeat : public Meat{
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        ChickenMeat(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);

};

#endif

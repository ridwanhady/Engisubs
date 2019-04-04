#ifndef _DOGMEAT_HPP_
#define _DOGMEAT_HPP_

#include "Meat.hpp"

//Kelas ini merepresentasikan produk daging Anjing.
class DogMeat : public Meat{
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        DogMeat(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);
};

#endif

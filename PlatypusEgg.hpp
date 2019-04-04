#ifndef _PLATYPUSEGG_HPP_
#define _PLATYPUSEGG_HPP_

#include "Egg.hpp"

//Kelas ini merepresentasikan produk telur Platipus.
class PlatypusEgg : public Egg {
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        PlatypusEgg(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);
};

#endif

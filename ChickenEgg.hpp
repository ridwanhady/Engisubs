#ifndef _CHICKENEGG_HPP_
#define _CHICKENEGG_HPP_

#include "Egg.hpp"

//Kelas ini merepresentasikan produk telur Ayam.
class ChickenEgg : public Egg {
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        ChickenEgg(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol );

};

#endif

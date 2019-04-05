#ifndef _BISONMEAT_HPP_
#define _BISONMEAT_HPP_

#include "Meat.hpp"

//Kelas ini merepresentasikan produk daging Bison.
class BisonMeat : public Meat{
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        BisonMeat(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);

};

#endif

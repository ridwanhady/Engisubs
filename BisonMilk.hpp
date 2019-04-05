#ifndef _BISONMILK_HPP_
#define _BISONMILK_HPP_

#include "Milk.hpp"

//Kelas ini merepresentasikan produk susu Bison.
class BisonMilk : public Milk {
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        BisonMilk(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);

};

#endif

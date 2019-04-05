#ifndef _PTERODACTYLEGG_HPP_
#define _PTERODACTYLEGG_HPP_
#include "Egg.hpp"

//Kelas ini merepresentasikan produk telur Pterodaktil.
class PterodactylEgg : public Egg{
    public:
        //Constructor menerima harga, dan mempassing producer untuk superclass.
        PterodactylEgg(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol);
};

#endif
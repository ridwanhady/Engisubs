#ifndef _MAYONAISE_H_
#define _MAYONAISE_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan mayonais.
class Mayonaise : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Mayonaise(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol);
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
};

#endif

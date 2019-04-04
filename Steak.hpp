#ifndef _STEAK_H_
#define _STEAK_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan steik.
class Steak : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Steak(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol);
        static void InitResep();
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
};

#endif

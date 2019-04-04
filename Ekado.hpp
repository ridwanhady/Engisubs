#ifndef _EKADO_H_
#define _EKADO_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan Ekado.
class Ekado : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Ekado(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol);
        static void InitResep();
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
};

#endif

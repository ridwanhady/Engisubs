#ifndef _EKADO_H_
#define _EKADO_H_

#include "SideProduct.hpp"
#define EKADO_PRICE 10

//Kelas ini merepresentasikan produk sampingan Ekado.
class Ekado : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
        static void InitResep();
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Ekado(int _price);
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
};

#endif

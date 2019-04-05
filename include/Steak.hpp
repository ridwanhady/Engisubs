#ifndef _STEAK_H_
#define _STEAK_H_

#include "SideProduct.hpp"
#define STEAK_PRICE 30

//Kelas ini merepresentasikan produk sampingan steik.
class Steak : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
        static void InitResep();
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Steak(int _price);
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
};

#endif

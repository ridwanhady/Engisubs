#ifndef _MAYONAISE_H_
#define _MAYONAISE_H_

#include "SideProduct.hpp"
#define MAYONAISE_PRICE 10

//Kelas ini merepresentasikan produk sampingan mayonais.
class Mayonaise : public SideProduct {
    private:
        static LinkedList<FarmProductType> resep;
        
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Mayonaise(int _price);
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
        static void InitResep();
};

#endif

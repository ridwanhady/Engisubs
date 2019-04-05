#ifndef _CHEESE_H_
#define _CHEESE_H_
#include "SideProduct.hpp"
#define CHEESE_PRICE 20
//Kelas ini merepresentasikan produk sampingan keju.
class Cheese : public SideProduct{
    private:
        static LinkedList<FarmProductType> resep;
        static void InitResep();

    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Cheese(int _price);
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
        
};

#endif

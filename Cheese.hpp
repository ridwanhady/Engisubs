#ifndef _CHEESE_H_
#define _CHEESE_H_
#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan keju.
class Cheese : public SideProduct{
    private:
        static LinkedList<FarmProductType> resep;
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Cheese(int _price);
        static void InitResep();
        static LinkedList<FarmProductType> getResep() {
            return resep;
        }
        static FarmProductType getResepwithIdx(int i);
        
};

#endif

#ifndef _STEAK_H_
#define _STEAK_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan steik.
class Steak : public SideProduct {
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Steak(int _price);
        static void InitResepSteak();
};

#endif

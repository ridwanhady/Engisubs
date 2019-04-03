#ifndef _EKADO_H_
#define _EKADO_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan Ekado.
class Ekado : public SideProduct {
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Ekado(int _price);
        static void InitResepEkado();
};

#endif

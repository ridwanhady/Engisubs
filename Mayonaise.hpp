#ifndef _MAYONAISE_H_
#define _MAYONAISE_H_

#include "SideProduct.hpp"

//Kelas ini merepresentasikan produk sampingan mayonais.
class Mayonaise : public SideProduct {
    public:
        //Constructor menerima harga, dan menginisialisasi resep.
        Mayonaise(int _price);
};

#endif

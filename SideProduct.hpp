#ifndef _SIDEPRODUCT_H_
#define _SIDEPRODUCT_H_

#include "Product.hpp"
#include "FarmProduct.hpp"
#include "LinkedList.hpp"

//Kelas ini merepresentasikan produk sampingan yang terdiri dari beberapa produk hewan.
class SideProduct : public Product {
    public:
        //Menyimpan resep dalam bentuk pointer.
        static LinkedList<ObjectType> resep;
        
        //Constructor tanpa parameter.
        SideProduct();

        //Menghasilkan produk pada resep dengan indeks i.
        FarmProduct getResep(int i) const;

        //Menambah resep.
        void addResep (ObjectType _product);
};

#endif

#ifndef _SIDEPRODUCT_H_
#define _SIDEPRODUCT_H_

#include "Product.hpp"
#include "FarmProduct.hpp"
#include "LinkedList.hpp"

//Kelas ini merepresentasikan produk sampingan yang terdiri dari beberapa produk hewan.
class SideProduct : public Product {
    private:
        //Menyimpan resep dalam bentuk pointer.
        LinkedList<FarmProduct*> resep;
    public:
        //Constructor tanpa parameter.
        SideProduct();

        //Destructor karena ada pointer.
        ~SideProduct();

        //Menghasilkan produk pada resep dengan indeks i.
        FarmProduct getResep(int i) const;

        //Menambah resep.
        void addResep (FarmProduct& _product);
};

#endif

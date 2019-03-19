#ifndef _SIDEPRODUCT_H_
#define _SIDEPRODUCT_H_

#include "Product.hpp"
#include "FarmProduct.hpp"
#include "LinkedList.hpp"

//Kelas ini merepresentasikan produk sampingan yang terdiri dari beberapa produk hewan.
class SideProduct : public Product {
    private:
        LinkedList<FarmProduct> resep;
    public:
        FarmProduct getResep(int i) const;
        void addResep (FarmProduct _product);
};

#endif

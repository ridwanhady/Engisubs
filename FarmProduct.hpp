#ifndef _FARMPRODUCT_HPP_
#define _FARMPRODUCT_HPP_
#include "Product.hpp"

class FarmProduct : public Product {
    private:

    public:
    	//Ctor tanpa parameter
        FarmProduct();
        //Virtual dtor
        virtual ~FarmProduct();
};

#endif
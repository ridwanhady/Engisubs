#ifndef _FARMPRODUCT_HPP_
#define _FARMPRODUCT_HPP_
#include "Product.hpp"

class FarmProduct : public Product {
    private:
      const string producer;
    public:
    	//Ctor tanpa parameter
      //FarmProduct();
      //Ctor dengan parameter
        FarmProduct(int _price);
      //Virtual dtor
      //virtual ~FarmProduct();
};

#endif

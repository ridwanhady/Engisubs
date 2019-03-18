#ifndef _PRODUCT_HPP
#define _PRODUCT_HPP

#include "Object.hpp"

enum ProductType {
	FARMPRODUCT,
	SIDEPRODUCT
}

class Product : public Object{
private:
	const ProductType productType;
	const int price;
public:
	//Ctor dengagn parameter
	Product(ProductType _productType, int _price);
	virtual void produce() = 0;
	void setPrice(int _price);
	int getPrice() const;
	char getProductType();
};

#endif

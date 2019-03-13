#ifndef _PRODUCT_HPP
#define _PRODUCT_HPP

#include "Object.hpp"

class Product : public Object{
private:
	const char productType;
public:
	//Ctor dengagn parameter
	Product(char _productType);
	virtual void produce() = 0;

	char getProductType();
};

#endif
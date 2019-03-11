#ifndef _PRODUCT_HPP
#define _PRODUCT_HPP

class Product{
private:
	const char type;
public:
	Product(char _ProductType)
	virtual void produce() = 0;

	char getProductType();
};

#endif
#include "Product.hpp"

//Ctor dengagn parameter
Product::Product(){
	// Default Price of Only Product
	this->price = 0;
}

//Mengambil harga.
int Product::getPrice() const{
	return price;
}

//Mengambil tipe produk.
ProductType Product::getProductType() const {
	return productType;
}

void Product::initializeProduct(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol) {
	price = _price;
	productType = _productType;
	objectType = _objectType;
	objectSymbol = _objectSymbol;
}
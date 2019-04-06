#include "../include/Product.hpp"

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

void Product::initializeProduct(int _price,  ProductType _productType, ObjectType _objectType, string _name) {
	price = _price;
	productType = _productType;
	objectType = _objectType;
	name = _name;
}

string Product::getName()  {
	return name;
}
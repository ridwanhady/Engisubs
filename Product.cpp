#include "Product.hpp"

//Ctor dengagn parameter
Product::Product(ProductType _productType, int _price) : productType(_productType), price(_price){

}

//Mengambil harga.
int Product::getPrice(){
	return price;
}

//Mengambil tipe produk.
ProductType Product::getProductType(){
	return productType;
}
#include "Product.hpp"

//Ctor dengagn parameter
Product::Product(ProductType _productType) : productType(_productType){

}

//Mengambil harga.
int Product::getPrice() const{
	return price;
}

//Mengambil tipe produk.
ProductType Product::getProductType() const {
	return productType;
}
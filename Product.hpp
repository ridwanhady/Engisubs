#ifndef _PRODUCT_HPP
#define _PRODUCT_HPP

#include "Object.hpp"

//Enumerator untuk tipe produk.
enum ProductType {
	FARMPRODUCT,
	SIDEPRODUCT
};

//Kelas ini merepresentasikan produk.
class Product : public Object{
	protected:
		//Tipe dari produk ini.
		ProductType productType;

		//Harga dari produk ini.
		int price;
	public:
		//Ctor dengagn parameter
		Product(ProductType _productType, int _price);

		//Mengambil harga.
		int getPrice() const;

		//Mengambil tipe produk.
		ProductType getProductType() const;
};

#endif

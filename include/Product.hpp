#ifndef _PRODUCT_HPP
#define _PRODUCT_HPP

#include "Object.hpp"
#include <string>

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
		string name;

		//Harga dari produk ini.
		int price;
	public:
		//Ctor dengan parameter
		Product();

		//Mengambil harga.
		int getPrice() const;

		//Mengambil tipe produk.
		ProductType getProductType() const;

		void initializeProduct(int _price,  ProductType _productType, ObjectType _objectType, string _name);

		//Mengambil nama produk
		string getName() ;

};

#endif

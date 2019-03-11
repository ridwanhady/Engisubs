#ifndef _OBJECT_HPP
#define _OBJECT_HPP

//Class untuk mendefinisikan tipe dari seluruh objek
class Object{
private:
	//Tipe dari suatu objek, misal: Product, T-Rex
	const string objectType;
	//Simbol dari suatu objek, misal: C untuk Ayam, ? untuk produk yang tidak memiliki simbol
	const char objectSymbol
public:
	//Ctor
	Object(string _objectType, char _objectSymbol = '?');
	//Untuk mengeluarkan simbol dari suatu objek ke layar
	void render();

	//Getter
	string getObjectType();
	char getObjectType();
};

#endif
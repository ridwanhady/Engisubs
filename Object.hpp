#ifndef _OBJECT_HPP
#define _OBJECT_HPP

using namespace std;

//Enumerator untuk tipe objek
enum ObjectType {
	Meja,
	Kursi
};

//Class untuk mendefinisikan tipe dari seluruh objek
class Object{
	private:
		//Tipe dari suatu objek, misal: Product, TRex
		const ObjectType objectType;
		//Simbol dari suatu objek, misal: C untuk Ayam, ? untuk produk yang tidak memiliki simbol
		const char objectSymbol;
	public:
		//Ctor
		Object(ObjectType _objectType, char _objectSymbol = '?');
		//Untuk mengeluarkan simbol dari suatu objek ke layar
		void render();
		//Virtual method untuk berinteraksi dengan interact
		virtual void interact() = 0;

		//Getter
		ObjectType getObjectType();
};

#endif
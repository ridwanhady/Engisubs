#ifndef _OBJECT_HPP
#define _OBJECT_HPP
#include <string>
#include <utility>
using namespace std;

//Enumerator untuk tipe objek
enum ObjectType {
	PLAYER,
	MIXER,
	TRUCK,
	WELL,
	BARN,
	COOP,
	GRASSLAND,
	CHICKEN,
	PLATYPUS,
	PTERODACTYL,
	BISON,
	DOG,
	TREX,
	CHICKEN_EGG,
	PLATYPUS_EGG,
	PTERODACTYL_EGG,
	BISON_MEAT,
	CHICKEN_MEAT,
	DOG_MEAT,
	PLATYPUS_MEAT,
	TREX_MEAT,
	BISON_MILK,
	PLATYPUS_MILK,
	CHEESE,
	EKADO,
	MAYONAISE,
	STEAK
};

//Enumerator untuk arah gerak.
enum DirectionType{
	UP,
	DOWN,
	RIGHT,
	LEFT
};

//Class untuk mendefinisikan tipe dari seluruh objek
class Object{
	protected:
		//Tipe dari suatu objek, misal: Product, TRex
		const ObjectType objectType;
		//Simbol dari suatu objek, misal: C untuk Ayam, ? untuk produk yang tidak memiliki simbol
		char objectSymbol;

	public:
		//Ctor dengan parameter
		Object(char _objectSymbol = '?');
		//Untuk mengeluarkan simbol dari suatu objek ke layar
		void render();
		//Virtual method untuk berinteraksi dengan interact
		virtual void interact() = 0;
		//Getter
		ObjectType getObjectType();
};

#endif

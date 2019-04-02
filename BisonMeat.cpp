#include "BisonMeat.hpp"


//Constructor menerima harga, dan mempassing producer untuk superclass.
BisonMeat::BisonMeat(int _price, string producer) : Meat(_price, producer){
	objectType = BISON_MEAT;
}
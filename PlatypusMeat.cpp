#include "PlatypusMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMeat::PlatypusMeat(int _price, string producer) : Meat(_price, producer){
	objectType = PLATYPUS_MEAT;
}
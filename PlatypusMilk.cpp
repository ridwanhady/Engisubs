#include "PlatypusMilk.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMilk::PlatypusMilk(int _price, string producer) : Milk(_price, producer){
	objectType = PLATYPUS_MILK;
}
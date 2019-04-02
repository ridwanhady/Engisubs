#include "PlatypusEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusEgg::PlatypusEgg(int _price, string producer) : Egg(_price, producer){
	objectType = PLATYPUS_EGG;	
}
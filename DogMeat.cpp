#include "DogMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
DogMeat::DogMeat(int _price, string producer) : Meat(_price, producer){
	objectType = DOG_MEAT;
}
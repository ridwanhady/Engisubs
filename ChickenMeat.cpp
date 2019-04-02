#include "ChickenMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenMeat::ChickenMeat(int _price, string producer) : Meat(_price, producer){
	objectType = CHICKEN_MEAT;
}
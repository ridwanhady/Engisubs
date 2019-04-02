#include "ChickenMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenMeat::ChickenMeat(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = CHICKEN_MEAT;
}
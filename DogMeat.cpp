#include "DogMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
DogMeat::DogMeat(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = DOG_MEAT;
}
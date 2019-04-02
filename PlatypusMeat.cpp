#include "PlatypusMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMeat::PlatypusMeat(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = PLATYPUS_MEAT;
}
#include "PlatypusMilk.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMilk::PlatypusMilk(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = PLATYPUS_MILK;
}
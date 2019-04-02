#include "BisonMeat.hpp"


//Constructor menerima harga, dan mempassing producer untuk superclass.
BisonMeat::BisonMeat(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = BISON_MEAT;
}
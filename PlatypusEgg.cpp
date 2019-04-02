#include "PlatypusEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusEgg::PlatypusEgg(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = PLATYPUS_EGG;
}
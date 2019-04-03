#include "ChickenEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenEgg::ChickenEgg(int _price, string _producer){
	producer = _producer;
	price = _price;
	objectType = CHICKEN_EGG;
}
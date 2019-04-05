#include "ChickenEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenEgg::ChickenEgg(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, CHICKEN_EGG, '?');
}
#include "../include/ChickenMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenMeat::ChickenMeat(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, CHICKEN_MEAT, '?');
}
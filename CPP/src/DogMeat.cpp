#include "../include/DogMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
DogMeat::DogMeat(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, DOG_MEAT, "Daging Anjing");
}
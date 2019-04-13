#include "../include/BisonMeat.hpp"


//Constructor menerima harga, dan mempassing producer untuk superclass.
BisonMeat::BisonMeat(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, BISON_MEAT, "Daging Bison");
}
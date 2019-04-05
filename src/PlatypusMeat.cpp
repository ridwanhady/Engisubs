#include "../include/PlatypusMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMeat::PlatypusMeat(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, PLATYPUS_MEAT, '?');
}
#include "PlatypusMilk.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMilk::PlatypusMilk(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, PLATYPUS_MILK, '?');
}
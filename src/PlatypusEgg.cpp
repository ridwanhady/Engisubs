#include "../include/PlatypusEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusEgg::PlatypusEgg(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, PLATYPUS_EGG, "Telur Platypus");
}
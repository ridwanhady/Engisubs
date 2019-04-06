#include "../include/TRexMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
TRexMeat::TRexMeat(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, TREX_MEAT, "Daging TRex");
}

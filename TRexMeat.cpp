#include "TRexMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
TRexMeat::TRexMeat(int _price, string producer) : Meat(_price, producer){
	objectType = TREX_MEAT;
}

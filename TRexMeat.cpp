#include "TRexMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
TRexMeat::TRexMeat(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = TREX_MEAT;
}

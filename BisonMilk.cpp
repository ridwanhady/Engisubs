#include "BisonMilk.hpp"

//Constructor menerima harga, dan menginisialisasi producer untuk superclass
BisonMilk::BisonMilk(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = BISON_MILK;
}

#include "BisonMilk.hpp"

//Constructor menerima harga, dan menginisialisasi producer untuk superclass
BisonMilk::BisonMilk(int _price, string producer) : Milk(_price, producer){
	objectType = BISON_MILK;
}

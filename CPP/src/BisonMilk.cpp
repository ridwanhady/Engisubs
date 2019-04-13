#include "../include/BisonMilk.hpp"

//Constructor menerima harga, dan menginisialisasi producer untuk superclass
BisonMilk::BisonMilk(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT,  BISON_MILK, "Susu Bison");
}

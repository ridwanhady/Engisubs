#include "BisonMilk.hpp"

//Constructor menerima harga, dan menginisialisasi producer untuk superclass
BisonMilk::BisonMilk(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol){
	initializeFarmProduct(_producer);
	initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

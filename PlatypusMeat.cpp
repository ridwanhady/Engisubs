#include "PlatypusMeat.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PlatypusMeat::PlatypusMeat(int _price, string _producer, ProductType _productType, ObjectType _objectType, char _objectSymbol){
	initializeFarmProduct(_producer);
	initializeProduct(_price, _productType, _objectType, _objectSymbol);
}
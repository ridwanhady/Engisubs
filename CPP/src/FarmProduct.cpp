#include "../include/FarmProduct.hpp"

//Constructor 
FarmProduct::FarmProduct() {
    
}
void FarmProduct::initializeFarmProduct(string _producer) {
	producer = _producer;
}

FarmProductType FarmProduct::getFarmProductType(ObjectType objectType) {
	if (objectType == CHICKEN_EGG || objectType == PLATYPUS_EGG || objectType == PTERODACTYL_EGG) {
		return EGG;
	} else if (objectType == BISON_MEAT || objectType == CHICKEN_MEAT || objectType == DOG_MEAT || objectType == PLATYPUS_MEAT || objectType == TREX_MEAT){
		return MEAT;
	} else if (objectType == BISON_MILK || objectType == PLATYPUS_MILK) {
		return MILK;
	} else {
		return NOT_FOUND;
	}
}
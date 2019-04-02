#include "ChickenEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
ChickenEgg::ChickenEgg(int _price, string producer) : Egg(_price, producer){
	objectType = CHICKEN_EGG;
}

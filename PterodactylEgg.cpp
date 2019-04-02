#include "PterodactylEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PterodactylEgg::PterodactylEgg(int _price, string producer) : Egg(_price, producer){
	objectType = PTERODACTYL_EGG;
}
#include "PterodactylEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PterodactylEgg::PterodactylEgg(int _price, string _producer){
	initializeFarmProduct(_producer);
	initializeProduct(_price, FARMPRODUCT, PTERODACTYL_EGG, '?');
}
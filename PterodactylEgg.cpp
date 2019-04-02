#include "PterodactylEgg.hpp"

//Constructor menerima harga, dan mempassing producer untuk superclass.
PterodactylEgg::PterodactylEgg(int _price, string _producer){
	price = _price;
	producer = _producer;
	objectType = PTERODACTYL_EGG;
}
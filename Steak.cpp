#include "Steak.hpp"

//Konstruktor Steak
Steak::Steak(int _price)  {
    price = _price;
}

void InitResep() {
    //Inisialisasi resep:
    Steak::resep.add(MEAT);
    Steak::resep.add(MILK);
}
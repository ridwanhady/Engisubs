#include "Mayonaise.hpp"

//Konstruktor Cheese
Mayonaise::Mayonaise(int _price)  {
    price = _price;
}

void InitResep() {
    //Inisialisasi resep:
    Mayonaise::resep.add(EGG);
    Mayonaise::resep.add(MILK);
}
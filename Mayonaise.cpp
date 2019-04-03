#include "Mayonaise.hpp"

//Konstruktor Cheese
Mayonaise::Mayonaise(int _price)  {
    price = _price;
}

void InitResepMayonaise() {
    //Inisialisasi resep:
    Mayonaise::resep.add(EGG);
    Mayonaise::resep.add(MILK);
}
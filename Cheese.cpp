#include "Cheese.hpp"

//Konstruktor Cheese
Cheese::Cheese(int _price)  {
    price = _price;
    
}

void InitResep() {
    //Inisialisasi resep:
    Cheese::resep.add(MILK);
    Cheese::resep.add(EGG);
}
#include "Cheese.hpp"

//Konstruktor Cheese
Cheese::Cheese(int _price)  {
    price = _price;
}

void InitResep() {
    //Inisialisasi resep:
    Cheese::getResep().add(MILK);
    Cheese::getResep().add(EGG);
}

FarmProductType getResepwithIdx(int i) {
    return Cheese::getResep().get(i);
}
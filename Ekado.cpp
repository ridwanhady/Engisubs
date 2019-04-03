#include "Ekado.hpp"

//Konstruktor Cheese
Ekado::Ekado(int _price)  {
    price = _price;
}

void InitResep() {
    //Inisialisasi resep:
    Ekado::resep.add(EGG);
    Ekado::resep.add(MEAT);
}
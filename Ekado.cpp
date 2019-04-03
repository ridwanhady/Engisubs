#include "Ekado.hpp"

//Konstruktor Cheese
Ekado::Ekado(int _price)  {
    price = _price;
}

void InitResepEkado() {
    //Inisialisasi resep:
    Ekado::resep.add(EGG);
    Ekado::resep.add(MEAT);
}
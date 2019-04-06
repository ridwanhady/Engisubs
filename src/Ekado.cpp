#include "../include/Ekado.hpp"

LinkedList<FarmProductType> Ekado::resep;

//Konstruktor Cheese
Ekado::Ekado(int _price)  {
    initializeProduct(_price, SIDEPRODUCT, EKADO, "Ekado");
    InitResep();
}

void Ekado::InitResep() {
    //Inisialisasi resep:
    resep.add(EGG);
    resep.add(MEAT);
}

FarmProductType Ekado::getResepwithIdx(int i) {
    return Ekado::getResep().get(i);
}
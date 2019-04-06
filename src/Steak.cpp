#include "../include/Steak.hpp"

LinkedList<FarmProductType> Steak::resep;

//Konstruktor Steak
Steak::Steak(int _price)  {
    initializeProduct(_price, SIDEPRODUCT, STEAK, "Steak");
    InitResep();
}

void Steak::InitResep() {
    //Inisialisasi resep:
    resep.add(MEAT);
    resep.add(MILK);
}

FarmProductType Steak::getResepwithIdx(int i) {
    return Steak::getResep().get(i);
}
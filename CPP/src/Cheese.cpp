#include "../include/Cheese.hpp"

LinkedList<FarmProductType> Cheese::resep;

//Konstruktor Cheese
Cheese::Cheese(int _price) {
    initializeProduct(_price, SIDEPRODUCT, CHEESE, "Keju");
    InitResep();
}

void Cheese::InitResep() {
    //Inisialisasi resep:
    resep.add(MILK);
    resep.add(EGG);
}

FarmProductType Cheese::getResepwithIdx(int i) {
    return Cheese::getResep().get(i);
}
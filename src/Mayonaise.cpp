#include "../include/Mayonaise.hpp"

LinkedList<FarmProductType> Mayonaise::resep;

//Konstruktor Cheese
Mayonaise::Mayonaise(int _price)  {
    initializeProduct(_price, SIDEPRODUCT, MAYONAISE, '?');
    InitResep();
}

void Mayonaise::InitResep() {
    //Inisialisasi resep:
    resep.add(EGG);
    resep.add(MILK);
}

FarmProductType Mayonaise::getResepwithIdx(int i) {
    return Mayonaise::getResep().get(i);
}
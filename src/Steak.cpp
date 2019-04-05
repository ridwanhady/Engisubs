#include "../include/Steak.hpp"

LinkedList<FarmProductType> Steak::resep;

//Konstruktor Steak
Steak::Steak(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol)  {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void Steak::InitResep() {
    //Inisialisasi resep:
    Steak::getResep().add(MEAT);
    Steak::getResep().add(MILK);
}

FarmProductType Steak::getResepwithIdx(int i) {
    return Steak::getResep().get(i);
}
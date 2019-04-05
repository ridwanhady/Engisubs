#include "../include/Ekado.hpp"

LinkedList<FarmProductType> Ekado::resep;

//Konstruktor Cheese
Ekado::Ekado(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol)  {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void Ekado::InitResep() {
    //Inisialisasi resep:
    Ekado::getResep().add(EGG);
    Ekado::getResep().add(MEAT);
}

FarmProductType Ekado::getResepwithIdx(int i) {
    return Ekado::getResep().get(i);
}
#include "../include/Cheese.hpp"

LinkedList<FarmProductType> Cheese::resep;

//Konstruktor Cheese
Cheese::Cheese(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol) {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void Cheese::InitResep() {
    //Inisialisasi resep:
    Cheese::getResep().add(MILK);
    Cheese::getResep().add(EGG);
}

FarmProductType Cheese::getResepwithIdx(int i) {
    
    return getResep().get(i);
}
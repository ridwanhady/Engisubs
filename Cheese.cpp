#include "Cheese.hpp"

//Konstruktor Cheese
Cheese::Cheese(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol) {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void InitResep() {
    //Inisialisasi resep:
    Cheese::getResep().add(MILK);
    Cheese::getResep().add(EGG);
}

FarmProductType getResepwithIdx(int i) {
    return Cheese::getResep().get(i);
}
#include "Mayonaise.hpp"

//Konstruktor Cheese
Mayonaise::Mayonaise(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol)  {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void InitResep() {
    //Inisialisasi resep:
    Mayonaise::getResep().add(EGG);
    Mayonaise::getResep().add(MILK);
}

FarmProductType getResepwithIdx(int i) {
    return Mayonaise::getResep().get(i);
}
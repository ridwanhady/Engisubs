#include "../include/Mayonaise.hpp"

LinkedList<FarmProductType> Mayonaise::resep;

//Konstruktor Cheese
Mayonaise::Mayonaise(int _price,  ProductType _productType, ObjectType _objectType, char _objectSymbol)  {
    initializeProduct(_price, _productType, _objectType, _objectSymbol);
}

void Mayonaise::InitResep() {
    //Inisialisasi resep:
    Mayonaise::getResep().add(EGG);
    Mayonaise::getResep().add(MILK);
}

FarmProductType Mayonaise::getResepwithIdx(int i) {
    return Mayonaise::getResep().get(i);
}
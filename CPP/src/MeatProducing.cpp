#include "../include/MeatProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
MeatProducing::MeatProducing(){
    killable = true;
    meat = NULL;
}

void MeatProducing::initializeMeatProducing(Meat* _meat){
    if (meat == NULL){
        meat = _meat;
    }
}

/*
Desktruktor
*/
MeatProducing::~MeatProducing(){
    if (meat != NULL){
        delete meat;
    }
}
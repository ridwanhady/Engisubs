#include "../include/MeatProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
MeatProducing::MeatProducing(){

}

void MeatProducing::initializeMeatProducing(Meat* _meat){
    if (meat == NULL){
        meat = _meat;
    }else {
        delete _meat;
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
#include "MilkProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
MilkProducing::MilkProducing(){

}

void MilkProducing::initializeMilkProducing(Milk* _milk){
    if (milk == NULL){
        milk = _milk;
    }else {
        delete _milk;
    }
}

/*
Desktruktor
*/

MilkProducing::~MilkProducing(){
    if (milk != NULL){
        delete milk;
    }
}
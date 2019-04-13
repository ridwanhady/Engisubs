#include "../include/MilkProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
MilkProducing::MilkProducing(){
	milk = NULL;
}

void MilkProducing::initializeMilkProducing(Milk* _milk){
    if (milk == NULL){
        milk = _milk;
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
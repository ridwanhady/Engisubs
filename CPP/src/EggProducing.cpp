#include "../include/EggProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
EggProducing::EggProducing(){
	egg = NULL;
}	

void EggProducing::initializeEggProducing(Egg* _egg){
    if (egg == NULL){
        egg = _egg;
    }
}

/*
Destructor.
*/
EggProducing::~EggProducing(){
    if (egg != NULL){
        delete egg;
    }
}
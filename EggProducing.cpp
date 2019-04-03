#include "EggProducing.hpp"

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari FarmAnimal.
*/
EggProducing::EggProducing(){

}

void EggProducing::initializeEggProducing(Egg* _egg){
    if (egg == NULL){
        egg = _egg;
    }else {
        delete _egg;
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
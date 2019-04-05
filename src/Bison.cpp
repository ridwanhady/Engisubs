#include <iostream>
#include "../include/Bison.hpp"

/*
Constructor yang menerima parameter position, name, meat, dan milk
Parameter diturunkan dari MeatProducing dan MilkProducing.
*/
Bison::Bison(pair<int,int> _position, string _name, Land* _landPos){
    initializeFarmAnimal(_position, _name, _landPos);
    initializeMeatProducing(new BisonMeat(HARGA_DAGING_BISON, getName()));
    initializeMilkProducing(NULL);
}

void Bison::produceMeat(Player& _player){
    if (meat != NULL){
        _player.addInventory(meat);
        meat = NULL;
    }
}

void Bison::produceMilk(Player& _player){
    if (milk != NULL){
        _player.addInventory(milk);
        milk = NULL;
    }
}

bool Bison::isKillable(){
    return true;
}

void Bison::eat(){
    FarmAnimal::eat();
    setIsProductProduced(false);
    initializeMilkProducing(new BisonMilk(HARGA_SUSU_BISON, getName()));
}

void Bison::talk(){
    cout << name << ": Mooo Ahahahah!" << endl;
}

void Bison::interact(Player* _p){
    if (!getIsProductProduced()){
        produceMilk(*_p);
        setIsProductProduced(true);
    }
}
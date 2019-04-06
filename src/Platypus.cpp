#include <iostream>
#include "../include/Platypus.hpp"

using namespace std;

/*
Constructor yang menerima parameter position, name, meat, dan milk serta egg
Parameter diturunkan dari MeatProducing dan MilkProducing dan EggProducing
*/
Platypus::Platypus(pair<int,int> _position, string _name, Land* _landPos){
    initObject(PLATYPUS, 'Y');
    initializeFarmAnimal(_position, _name, _landPos);
    initializeMeatProducing(new PlatypusMeat(HARGA_DAGING_PLATYPUS, getName()));
    initializeEggProducing(NULL);
    initializeMilkProducing(NULL);
    setIsProductProduced(true);
}

/*
Method untuk memproduksi daging Platypus. Method diturunkan dari
MeatProducing
*/
void Platypus::produceMeat(Player& _player){
    if (meat != NULL){
        _player.addInventory(meat);
        meat = NULL;
    }
}

/*
Method untuk memproduksi susu Platypus. Method diturunkan dari
MilkProducing
*/
void Platypus::produceMilk(Player& _player){
    if (milk != NULL){
        _player.addInventory(milk);
        milk = NULL;
    }
}

/*
Method untuk memproduksi egg Platypus. Method diturunkan dari
EggProducing
*/
void Platypus::produceEgg(Player& _player){
    if (egg != NULL){
        _player.addInventory(egg);
        egg = NULL;
    }
}

void Platypus::eat(){
    FarmAnimal::eat();
    cout <<"testPlatypusMakan1"  << endl;
    setIsProductProduced(false);
    cout << "testPlatypusMakan" << endl;
    initializeEggProducing(new PlatypusEgg(HARGA_TELUR_PLATYPUS, getName()));
    initializeMilkProducing(new PlatypusMilk(HARGA_SUSU_PLATYPUS, getName()));
}

void Platypus::talk(){
    cout << name << ": Eyy, what the hell?" << endl;
}

void Platypus::interact(Player* _p){
    cout << "PLATYPUS INTERACT" << endl;
    if (!getIsProductProduced()){
        cout << "PLATYPUS INTERACT KEDUA" << endl;
        produceEgg(*_p);
        produceMilk(*_p);
        cout << "PLATYPUS INTERACT KETIGA" << endl;
        setIsProductProduced(true);
    }
}
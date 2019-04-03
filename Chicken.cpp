#include <iostream>
#include "Chicken.hpp"

using namespace std;

/*
Constructor yang menerima parameter position, name, egg, dan meat
Parameter diturunkan dari EggProducing dan MeatProducing.
*/
Chicken::Chicken(pair<int,int> _position, string _name, Land* _landPos){
    initializeFarmAnimal(_position, _name, _landPos);
    initializeMeatProducing(new ChickenMeat(HARGA_DAGING_AYAM, getName()));
    initializeEggProducing(NULL);
    setIsProductProduced(true);
}

/*
Method untuk mengetahui apakah Chicken sudah mati
karena dagingnya diproduksi. Method diturunkan dari
MeatProducing
*/
void Chicken::produceMeat(Player& _player){
    if (meat != NULL){
        _player.addInventory(meat);
        meat = NULL;
    }
}

/*
Method untuk mengetahui apakah Chicken sudah
memproduksi susu. Method diturunkan dari
MilkProducing
*/
void Chicken::produceEgg(Player& _player){
    if (egg != NULL){
        _player.addInventory(egg);
        egg = NULL;
    }
}

bool Chicken::isKillable(){
    return true;
}

void Chicken::eat(){
    FarmAnimal::eat();
    setIsProductProduced(false);
    initializeEggProducing(new ChickenEgg(HARGA_TELUR_AYAM, getName()));
}

void Chicken::talk(){
    cout << name << ": Petok Petok" << endl;
}

void Chicken::interact(Player* _p){
    if (!getIsProductProduced()){
        produceEgg(*_p);
        setIsProductProduced(true);
    }
}
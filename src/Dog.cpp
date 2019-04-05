#include <iostream>
#include "../include/Dog.hpp"

using namespace std;

/*
Constructor yang menerima parameter position, name, meat.
Parameter diturunkan dari MeatProducing.
*/
Dog::Dog(pair<int,int> _position, string _name, Land* _landPos){
    initObject(DOG, 'D');
    initializeFarmAnimal(_position, _name, _landPos);
    initializeMeatProducing(new DogMeat(HARGA_DAGING_ANJING, getName()));
}

/*
Method untuk mengetahui apakah Dog sudah mati
karena dagingnya diproduksi. Method diturunkan dari
MeatProducing
*/
void Dog::produceMeat(Player& _player){
    if (meat != NULL){
        _player.addInventory(meat);
        meat = NULL;
    }
}

bool Dog::isKillable(){
    return true;
}

void Dog::eat(){
    FarmAnimal::eat();
}

void Dog::talk(){
    cout << name << ": Guk Guk Ruyuk!" << endl;
}
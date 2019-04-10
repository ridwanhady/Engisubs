#include <iostream>
#include "../include/Pterodactyl.hpp"

using namespace std;

/*
Constructor yang menerima parameter position, name, egg.
Parameter diturunkan dari EggProducing
*/
Pterodactyl::Pterodactyl(pair <int,int> _position, string _name, Land* _landPos){
    initObject(PTERODACTYL, 'L');
    initializeFarmAnimal(_position, _name, _landPos);
    initializeEggProducing(NULL);
}

/*
Method untuk memproduksi egg. Method diturunkan dari
EggProducing
*/
void Pterodactyl::produceEgg(Player& _player){
    initObject(PTERODACTYL, 'L');
    if (egg != NULL){
        _player.addInventory(new PterodactylEgg(HARGA_TELUR_PTERODACTYL, getName()));
        delete egg;
    }
}

void Pterodactyl::eat(){
    FarmAnimal::eat();
    setIsProductProduced(false);
    initializeEggProducing(new PterodactylEgg(HARGA_TELUR_PTERODACTYL, getName()));
}

void Pterodactyl::talk(){
    cout << name << ": Nyehehehehe" << endl;
}

void Pterodactyl::interact(Player* _p){
    if (!getIsProductProduced()){
        produceEgg(*_p);
        setIsProductProduced(true);
    }
}
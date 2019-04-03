#include <iostream>
#include "TRex.hpp"

using namespace std;

/*
Constructor yang menerima parameter position, name, meat.
Parameter diturunkan dari MeatProducing.
*/
TRex::TRex(pair<int,int> _position, string _name, Land* _landPos){
    initializeFarmAnimal(_position, _name, _landPos);
    initializeMeatProducing(new TRexMeat(HARGA_DAGING_TREX, getName()));
}

/*
Method untuk memproduksi meat dan membuat hewan mati.
*/
void TRex::produceMeat(Player& _player){
    if (meat != NULL){
        _player.addInventory(meat);
        meat = NULL;
    }
}

bool isKillable(){
    return true;
}

void TRex::eat(){
    FarmAnimal::eat();
}

void TRex::talk(){
    cout << name << ": Reeeeeeeeeek!" << endl;
}
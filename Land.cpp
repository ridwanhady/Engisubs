#include "Land.hpp"

Land::Land(pair<int,int> _position, bool _isGrown, LandType _landType) : Cell(_position), landType(_landType){
    grown = _isGrown;
    
}

//Menambah/mengurangi object saat ini dan mengganti isOccupied
void Land::setObjectHere(Object* _objectHere){
    objectHere = _objectHere;
    occupied = true;
}

//Menumbuhkan rumput di cell
void Land::grow(){
    grown = true;
}
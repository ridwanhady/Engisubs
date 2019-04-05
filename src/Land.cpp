#include "../include/Land.hpp"
#include <iostream>

using namespace std;

//Ctor dengan parameter
Land::Land(pair<int,int> _position, bool _isGrown, LandType _landType) : Cell(_position), landType(_landType){
	objectType = LAND;
	grown = _isGrown;
	if(grown){
		objectSymbol = grassSymbol[landType];
	} else {
		objectSymbol = landSymbol[landType];
	}
}

//Menambah/mengurangi object saat ini dan mengganti isOccupied
void Land::setObjectHere(Object* _objectHere){
	objectHere = _objectHere;
	if(objectHere == NULL) occupied = false;
	else occupied = true;
}

//Menumbuhkan rumput di cell
void Land::grow(){
    grown = true;
	objectSymbol = grassSymbol[landType];
}

//Getter object saat ini

Object* Land::getObjectHere() {
	return objectHere;
}

//Menghilangkan rumput di cell
void Land::ungrow(){
	grown = false;
	objectSymbol = landSymbol[landType];
}

void Land::render(){
	if (isOccupied()){
		cout << objectHere->objectSymbol;
	}else {
		Object::render();
	}
}
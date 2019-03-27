#include "Land.hpp"

//Ctor dengan parameter
Land::Land(pair<int,int> _position, bool _isGrown, LandType _landType) : landType(_landType){
	position = _position;
	isGrown = _isGrown;
	if(isGrown){
		objectSymbol = grassSymbol[landType];
	} else {
		objectSymbol = grassSymbol[landType];
	}
}

//Menambah/mengurangi object saat ini dan mengganti isOccupied
void Land::setObjectHere(Object& _objectHere){
	objectHere = _objectHere;
	if(objectHere == NULL)isOccupied = false;
	else isOccupied = true;
}

//Menumbuhkan rumput di cell
void Land::grow(){
	isGrown = true;
	objectSymbol = grassSymbol[landType];
}

//Menghilangkan rumput di cell
void Land::ungrow(){
	isGrown = false;
	objectSymbol = landSymbol[landType];
}
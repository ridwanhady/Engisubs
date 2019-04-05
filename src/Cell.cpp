#include "../include/Cell.hpp"

//Ctor dengan parameter
Cell::Cell(pair<int,int> _position) : position(_position){
	
}

//Getter
pair<int,int> Cell::getPosition(){
	return position;
}

//Setter
void Cell::setPosition(pair<int,int> _position){
	position= _position;
}
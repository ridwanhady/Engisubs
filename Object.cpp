#include "Object.hpp"
#include <iostream>
using namespace std;

//Ctor dengan parameter
Object::Object(ObjectType _objectType, char _objectSymbol = '?') : objectType(_objectType), objectSymbol(_objectSymbol){

}

//Untuk mengeluarkan simbol dari suatu objek ke layar
void Object::render(){
	cout<<objectSymbol;
}
//Getter
ObjectType Object::getObjectType(){
	return objectType;
}
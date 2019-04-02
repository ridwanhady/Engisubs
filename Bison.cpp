#include "Bison.hpp"

Bison::Bison(pair<int,int> _position, string _name, Meat* _meat, Milk* _milk) : MeatProducing(_position, _name, _meat), MilkProducing(_position, _name, _milk){

}
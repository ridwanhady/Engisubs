#ifndef _GRASSLAND_HPP
#define _GRASSLAND_HPP

#include "Land.hpp"

class Grassland : public Land {
    public:
    	//Ctor dengan parameter
        Grassland(pair<int,int> _position, bool _isGrown);
};

#endif
#ifndef _COOP_HPP
#define _COOP_HPP

#include "Land.hpp"

class Coop : public Land{
    public:
    	//Ctor dengan parameter
        Coop(pair<int,int> _position, bool _isGrown);
};

#endif
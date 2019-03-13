#ifndef _BARN_HPP
#define _BARN_HPP

#include "Land.hpp"

class Barn : public Land{
    public:
    	//Ctor dengan parameter
        Barn(bool _isGrown);
};

#endif
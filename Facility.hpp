#ifndef _FACILITY_HPP
#define _FACILITY_HPP

#include "Object.hpp"

class Facility : public Object{
private:

public:
	Facility(string _ObjectType = "Facility", char _objectSymbol = '?');
};

#endif
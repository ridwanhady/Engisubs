#ifndef _FACILITY_HPP
#define _FACILITY_HPP

#include "Land.hpp"

using namespace std;

class Facility : public Land{
    public:
        bool isWalkable(){
            return false;
        }
};

#endif
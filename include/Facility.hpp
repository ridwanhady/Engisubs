#ifndef _FACILITY_HPP
#define _FACILITY_HPP

#include "Land.hpp"

using namespace std;

class Facility : public Cell{
    public:
    	//Constructor, menginisialisasi posisi
    	Facility(pair<int,int> _position);
    	//Facility tidak bisa dilangkahi
        bool isWalkable(){
            return false;
        }
};

#endif
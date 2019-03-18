#ifndef _WELL_HPP
#define _WELL_HPP

#include "Facility.hpp"

class Well : public Facility{
    public:
    	//Constructor, menginisialisasi posisi
    	Well(pair<int,int> _position);
        void interact();
};

#endif
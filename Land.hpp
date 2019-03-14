#ifndef _LAND_HPP
#define _LAND_HPP

#include "Cell.hpp"

enum LandType {
    GRASSLAND,
    BARN,
    COOP
};

class Land : public Cell{
    private:
        bool isGrown;
        LandType landType;

    public:
        //Ctor dengan parameter
        Land(bool _isGrown);
        //Land dapat dilangkahi
        bool isWalkable(){
            return true;
        }

        bool isGrown();

        void grow();

};

#endif
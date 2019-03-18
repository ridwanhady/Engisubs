#ifndef _LAND_HPP
#define _LAND_HPP

#include "Cell.hpp"
#include "LinkedList.hpp"

enum LandType {
    GRASSLAND,
    BARN,
    COOP
};

class Land : public Cell{
    private:
        bool isGrown;
        bool isOccupied;
        LandType landType;
        LinkedList<Object> objectHere;

    public:
        //Ctor dengan parameter
        Land(bool _isGrown);
        //Land dapat dilangkahi
        bool isWalkable(){
            return true;
        }

        bool isGrown(){
            return isGrown;
        }

        bool isOccupied;

        void grow();

};

#endif
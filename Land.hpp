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
        const LandType landType;
        Object& objectHere = NULL;

    public:
        //Ctor dengan parameter
        Land(pair<int,int> _position, bool _isGrown, LandType _landType);

        //Land dapat dilangkahi
        bool isWalkable(){
            return true;
        }

        //Mengecek apakah terdapat rumput di cell ini
        bool isGrown(){
            return isGrown;
        }

        //Mengecek apakah terdapat FarmAnimal atau Player disini
        bool isOccupied(){
            return isOccupied;
        }

        //Menambah/mengurangi object saat ini dan mengganti isOccupied
        void setObjectHere(Object& _objectHere);

        //Menumbuhkan rumput di cell
        void grow();

};

#endif
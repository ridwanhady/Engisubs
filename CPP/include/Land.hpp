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
        bool grown;
        bool occupied = false;
        const LandType landType;
        Object* objectHere = NULL;
        char landSymbol[3] = {'-', 'x', 'o'};
        char grassSymbol[3] = {'#', '@', '*'};

    public:
        //Ctor dengan parameter
        Land(pair<int,int> _position, bool _isGrown, LandType _landType);

        //Land dapat dilangkahi
        bool isWalkable(){
            return true;
        }

        //Mengecek apakah terdapat rumput di cell ini
        bool isGrown(){
            return grown;
        }

        //Mengecek apakah terdapat FarmAnimal atau Player disini
        bool isOccupied(){
            return occupied;
        }

        //Menambah/mengurangi object saat ini dan mengganti isOccupied
        void setObjectHere(Object* _objectHere);

        //Menumbuhkan rumput di cell
        void grow();

        //Getter object saat ini
        Object* getObjectHere();

        //Menghilangkan rumput di cell
        void ungrow();

        void render();

};

#endif
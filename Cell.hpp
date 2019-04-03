#ifndef _CELL_HPP
#define _CELL_HPP

#include "Object.hpp"

class Cell : public Object{
    protected:
        pair<int,int> position;

    public:
    	//Ctor dengan parameter
        Cell(pair<int,int> _position);

        //Virtual method untuk mengecek apakah suatu petak dapat dilangkahi player atau tidak
        virtual bool isWalkable();

        //Getter
        pair<int,int> getPosition();

        //Setter
        void setPosition(pair<int,int> _position);
};

#endif
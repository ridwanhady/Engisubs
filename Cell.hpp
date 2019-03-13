#ifndef _CELL_HPP
#define _CELL_HPP

#include "Object.hpp"

class Cell : public Object{
    private:
        int baris;
        int kolom;

    public:
    	//Ctor dengan parameter
        Cell(int _baris, int _kolom);

        //Virtual method untuk mengecek apakah suatu petak dapat dilangkahi player atau tidak
        virtual bool isWalkable() = 0;
};

#endif
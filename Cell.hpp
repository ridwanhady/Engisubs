#ifndef _CELL_HPP
#define _CELL_HPP

#include "Object.hpp"

class Cell : public Object{
    private:
        int baris;
        int kolom;

    public:
        Cell(int _baris, int _kolom);

        virtual bool isWalkable() = 0;
};

#endif
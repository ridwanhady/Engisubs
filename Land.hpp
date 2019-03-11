#ifndef _LAND_HPP
#define _LAND_HPP

#include "Cell.hpp"

class Land : public Cell{
    private:
        bool isGrown;
        enum landType {GRASSLAND, BARN, COOP};

    public:
        Land(bool _isGrown);

        bool isWalkable();

        bool isGrown();

        void grow();

};

#endif
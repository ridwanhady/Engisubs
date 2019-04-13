#ifndef _MAP_HPP_
#define _MAP_HPP_
#include "CellDependencies.hpp"
#include <vector>
#include <string>

class Map{
    private:
        vector<vector<Cell>> contents;
    public:
        //Ctor that act as initialization
        Map();
        Map(string filename); 
        void initMap(string filename); 
};



#endif
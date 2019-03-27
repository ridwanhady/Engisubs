#include "Grassland.hpp"

Grassland::Grassland(pair<int,int> _position, bool _isGrown) : Land(_position, _isGrown, GRASSLAND){
    objectType = LAND;
}
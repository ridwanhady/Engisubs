#include "Coop.hpp"

Coop::Coop(pair<int,int> _position, bool _isGrown) : Land(position, _isGrown, COOP) {
	objectType = COOP;
}

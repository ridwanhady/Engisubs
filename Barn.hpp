#ifndef _BARN_HPP
#define _BARN_HPP

#include "Land.hpp"

class Barn : public Land{
  public:
      Barn(pair<int,int> _position, bool _isGrown);
      /*
      Constructor yang menerima parameter posisi dan isGrown, yaitu
      apakah petak itu bisa ditumbuhkan atau tidak.
      */
};

#endif

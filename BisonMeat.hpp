#ifndef _BISONMEAT_HPP_
#define _BISONMEAT_HPP_

#include "Meat.hpp"

class BisonMeat : public Meat{
    public:
      /*
      Constructor yang menerima parameter price,
      price adalah atribut dari Product
      */
      BisonMeat(int _price);
};

#endif

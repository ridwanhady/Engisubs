#ifndef _DOGMEAT_HPP_
#define _DOGMEAT_HPP_

#include "Meat.hpp"

class DogMeat : public Meat{
    public:
      /*
      Constructor yang menerima parameter price,
      price adalah atribut dari Product
      */
      DogMeat(int _price = 15);
};

#endif

#ifndef _CHICKENMEAT_HPP_
#define _CHICKENMEAT_HPP_

#include "Meat.hpp"

class ChickenMeat : public Meat{
    public:
      /*
      Constructor yang menerima parameter price,
      price adalah atribut dari Product
      */
      ChickenMeat(int _price = 5);
};

#endif

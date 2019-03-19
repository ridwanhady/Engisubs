#ifndef _TREXMEAT_HPP_
#define _TREXMEAT_HPP_
#include "Meat.hpp"

class TRexMeat : public Meat{
    public:
      /*
      Constructor yang menerima parameter price,
      price adalah atribut dari Product.
      */
      TRexMeat(int _price = 20);
};

#endif

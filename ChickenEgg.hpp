#ifndef _CHICKENEGG_HPP_
#define _CHICKENEGG_HPP_
#include "Egg.hpp"

class ChickenEgg : public Egg {
    public:
      /*
      Constructor yang menerima parameter price,
      price adalah atribut dari Product
      */
      ChickenEgg(int _price);
};

#endif

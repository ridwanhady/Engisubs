#ifndef _EGGPRODUCING_HPP_
#define _EGGPRODUCING_HPP_

#include "FarmAnimal.hpp"

class EggProducing : FarmAnimal {
protected:
  Egg E;
public:
  EggProducing(Egg);
  EggProducing(const EggProducing&);
  EggProducing& operator= (const EggProducing&);
  virtual ~EggProducing();
};
#endif

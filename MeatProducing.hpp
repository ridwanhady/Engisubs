#ifndef _MEATPRODUCING_HPP_
#define _MEATPRODUCING_HPP_

#include "FarmAnimal.hpp"

class MeatProducing: FarmAnimal {
protected:
  Meat M;
public:
  EggProducing(Meat);
  EggProducing(const EggProducing&);
  EggProducing& operator= (const EggProducing&);
  virtual ~EggProducing();
};
#endif

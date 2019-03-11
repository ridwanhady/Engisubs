#ifndef _MILKPRODUCING_HPP_
#define _MILKPRODUCING_HPP_

#include "FarmAnimal.hpp"

class MilkProducing : FarmAnimal {
protected:
  Milk M;
public:
  MilkProducing(Milk);
  MilkProducing(const MilkProducing&);
  MilkProducing& operator= (const MilkProducing&);
  virtual ~MilkProducing();
};
#endif

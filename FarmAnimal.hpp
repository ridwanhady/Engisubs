#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"

class FarmAnimal : public Object {
public:
  FarmAnimal();
  FarmAnimal(const FarmAnimal&);
  FarmAnimal& operator= (const FarmAnimal&);
  virtual ~FarmAnimal();
};
#endif

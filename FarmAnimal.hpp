#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_
class FarmAnimal {
public:
  FarmAnimal();
  FarmAnimal(const FarmAnimal&);
  FarmAnimal& operator= (const FarmAnimal&);
  virtual ~FarmAnimal();
};
#endif

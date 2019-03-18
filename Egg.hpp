#ifndef _EGG_HPP_
#define _EGG_HPP_

#include "FarmProduct.hpp"
using namespace std;
class Egg : public FarmProduct{
    private:
        int price;
    public:
      Egg(int _price);
};

#endif

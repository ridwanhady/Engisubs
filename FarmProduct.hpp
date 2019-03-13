#ifndef _FARMPRODUCT_HPP_
#define _FARMPRODUCT_HPP_

#include "Object.hpp"

class FarmProduct : public Object {
    private:

    public:
    	//Ctor tanpa parameter
        FarmProduct();
        //Virtual dtor
        virtual ~FarmProduct();
};

#endif
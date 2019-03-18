#ifndef _EKADO_H_
#define _EKADO_H_

#include "SideProduct.hpp"

class Ekado : public SideProduct {
    private:
        //ATTRIBUTE NEEDED
        static int totalEkado;
    public:
        //METHODS NEEDED
        Ekado(Meat, Egg);
};

#endif

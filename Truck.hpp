#ifndef _TRUCK_HPP
#define _TRUCK_HPP

#include "Facility.hpp"

class Truck : public Facility{
    private:
        int notUsableTurns;
    public:
        //Constructor, menginisialisasi posisi
        Truck(pair<int,int> _position);

        void interact();

        bool isUsable(){
            return notUsableTurns == 0;
        }

        int getNotUsableTurns(){
            return notUsableTurns;
        }

        int setNotUsableTurns();
};

#endif
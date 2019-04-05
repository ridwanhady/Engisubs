#ifndef _MIXER_HPP
#define _MIXER_HPP

#include "Facility.hpp"
using namespace std;

class Mixer : public Facility{
	public:
    	//Constructor, menginisialisasi posisi
		Mixer(pair<int,int> _position);

		//Implementasi virtual interact()
		void interact(Player* _p);
};

#endif

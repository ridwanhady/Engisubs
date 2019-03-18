// Player.hpp

#ifndef PLAYER_HPP
#define PLAYER_HPP

#include <string>
#include "Product.hpp"

#define MAX_WATER 100
#define MAX_INVENTORY 10

using namespace std;

class Player : public Object{
	public:
		// ctor tanpa parameter
		Player();		
		
		// ctor dengan parameter
		Player(string _name, int _water, Product* _inventory, double _uang); 
		
		// getter
		string getName();
		int getWater();
		Product* getInventory();
		double getUang();
		
		// setter
		void setName(string _name);
		void setWater(int _water);
		void setInventory(Product* _tas);
		void setUang(double _uang);	
	
		// command
		void talk();
		void interact();
		void kill();
		void grow();
		void mix();
	private:
		string player_name; //nama pemain
		int water;	    //kapasitas air
        	Product* inventory; //tas/inventory
		double uang;	    //uang pemain
};

#endif
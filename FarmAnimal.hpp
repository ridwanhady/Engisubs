#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"

class FarmAnimal : public Object {
	private:
		pair<int,int> position;
		bool isHungry = false;
		int timeUntilDead = 100;
		int timeUntilHungry = 100;
	public:
  		FarmAnimal(pair<int,int> _position);
  		FarmAnimal(const FarmAnimal&);
  		FarmAnimal& operator= (const FarmAnimal&);
  		virtual ~FarmAnimal();

  		//Getter
  		pair<int,int> getPosition();
  		bool getIsHungry();
  		int getTimeUntilDead();
  		int getTimeUntilHungry();

  		//Setter
  		void setPosition(pair<int,int> _position);
  		void setIsHungry(bool _isHungry);
  		void setTimeUntilDead(int _timeUntilDead);
  		void setTimeUntilHungry(int _timeUntilHungry);
};
#endif

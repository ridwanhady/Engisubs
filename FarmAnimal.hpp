#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"

class FarmAnimal : public Object {
	private:
		pair<int,int> position;
		bool isHungry = false;
		int timeUntilDead = 100;
		int timeUntilHungry = 100;
		bool isProductProduced = false;
	public:
  		FarmAnimal(pair<int,int> _position);
  		FarmAnimal(const FarmAnimal&);
  		FarmAnimal& operator= (const FarmAnimal&);
  		~FarmAnimal();

  		//Getter
  		pair<int,int> getPosition();
  		bool getIsHungry();
  		int getTimeUntilDead();
  		int getTimeUntilHungry();
  		bool getIsProductProduced();

  		//Setter
  		void setPosition(pair<int,int> _position);
  		void setIsHungry(bool _isHungry);
  		void setTimeUntilDead(int _timeUntilDead);
  		void setTimeUntilHungry(int _timeUntilHungry);
  		void getIsProductProduced(bool _isProductProduced);

  		//Memakan rumput di tempatnya
  		void eat();

  		//Bergerak
  		void move(DirectionType direction);

  		//Mengupdate keadaan animal
  		//Jika isHungry = True, timeUntilDead = timeUntilDead-1
  		//Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
  		void updateCondition();
};
#endif

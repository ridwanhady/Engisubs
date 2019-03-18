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
      string name = "";

	public:
      //Constructor. Menambahkan jumlah hewan.
  		FarmAnimal(pair<int,int> _position);

      //Copy Constructor. Menambahkan jumlah hewan.
  		FarmAnimal(const FarmAnimal&);

      //Destructor. Mengurangi jumlah hewan.
  		~FarmAnimal();

  		//Getter
  		pair<int,int> getPosition();
  		int getTimeUntilDead();
  		int getTimeUntilHungry();
  		bool getIsProductProduced();

  		//Setter
  		void setPosition(pair<int,int> _position);
  		void setTimeUntilDead(int _timeUntilDead);
  		void setTimeUntilHungry(int _timeUntilHungry);
  		void setIsProductProduced(bool _isProductProduced);


      bool isHungry(){
        return (timeUntilHungry == 0);
      }
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

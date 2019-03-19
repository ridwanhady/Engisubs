#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"

class FarmAnimal : public Object {
	private:

			//Atribut posisi
  		pair<int,int> position;

			//Atribut menandakan FarmAnimal sudah makan atau belum.
  		bool isHungry = false;

			//Atribut menandakan waktu sebelum FarmAnimal mati.
  		int timeUntilDead = 100;

			// Atribut menandakan waktu sebelum FarmAnimal lapar.
  		int timeUntilHungry = 100;

			//Atribut menandakan
  		bool isProductProduced = false;

			//Atribut nama dari FarmAnimal
      string name = "";

	public:
      /*
      Constructor yang menerima parameter posisi, nama)
      */
  		FarmAnimal(pair<int,int> _position, string _name);

      /*
      Destructor untuk mengurangi jumlah hewan.
      */
  		~FarmAnimal();

  		//Getter

			//Mendapatkan position
  		pair<int,int> getPosition();

			//Mendapat waktu sebelum hewan mati
  		int getTimeUntilDead();

			//Mendapat waktu sebelum hewan lapar
  		int getTimeUntilHungry();

			//Mendapat apakah produk sudah diproduksi
  		bool getIsProductProduced();

			//Mendapat nama dari FarmAnimal
      string getName();

  		//Setter

			//Menge-set posisi FarmAnimal
  		void setPosition(pair<int,int> _position);

			//Menge-set waktu sebelum hewan mati
  		void setTimeUntilDead(int _timeUntilDead);

			//Menge-set waktu sebelum hewan lapar
  		void setTimeUntilHungry(int _timeUntilHungry);

			 //Menge-set apakah produk sudah diproduksi
  		void setIsProductProduced(bool _isProductProduced);

			//Menge-set nama dari FarmAnimal
      void setName(string _name);

      //Method untuk mengembalikan apakah hewan dalam keadaan lapar
      bool isHungry(){
        return (timeUntilHungry == 0);
      }

			//Method untuk makan rumput di tempat hewan itu berdiri
  		void eat();

  		//Bergerak
  		void move(DirectionType direction, LinkedList<Cell> map);


  		//Method untuk mengupdate keadaan animal
  		//Jika isHungry = True, timeUntilDead = timeUntilDead-1
  		//Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
  		void updateCondition();
};
#endif

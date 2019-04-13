#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"
#include "Land.hpp"

#define TIME_UNTIL_HUNGRY_DEFAULT 0
#define TIME_UNTIL_DEAD_DEFAULT 1000

class FarmAnimal : public Object {
	protected:
			static int animalCount;

			//Atribut posisi
  		pair<int,int> position;

			//Atribut menandakan FarmAnimal sudah makan atau belum.
  		bool hungry = false;

			//Atribut menandakan waktu sebelum FarmAnimal mati.
  		int timeUntilDead = TIME_UNTIL_DEAD_DEFAULT;

			// Atribut menandakan waktu sebelum FarmAnimal lapar.
  		int timeUntilHungry = TIME_UNTIL_HUNGRY_DEFAULT;

			//Atribut menandakan hewan sudah memroduksi produk saat ini.
  		bool isProductProduced = false;

			//Atribut nama dari FarmAnimal
      string name = "";

			//Menunjuk ke Land tempat Animal berada.
			Land *landPos;

			bool killable = false;

	public:
      /*
      Constructor yang menerima parameter posisi, nama)
      */
  		FarmAnimal();

			void initializeFarmAnimal(pair<int,int> _position, string _name, Land *_landPos);

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

			//Mendapat Land tempat hewan berada
			Land* getLandPos();

			bool isKillable(){
				return killable;
			}

			virtual void talk() = 0;

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

			//Menge-set Land tempat hewan berada
			void setLandPos(Land *_newLand);

      //Method untuk mengembalikan apakah hewan dalam keadaan lapar
      bool isHungry(){
        return (timeUntilHungry == 0);
      }

			//Method untuk makan rumput di tempat hewan itu berdiri
  		virtual void eat();

  		//Bergerak
  		void move(DirectionType direction, LinkedList<LinkedList<Cell*>*>* map);


  		//Method untuk mengupdate keadaan animal
  		//Jika isHungry = True, timeUntilDead = timeUntilDead-1
  		//Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
  		void updateCondition();
};
#endif

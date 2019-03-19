#ifndef _FARMANIMAL_HPP_
#define _FARMANIMAL_HPP_

#include "Object.hpp"

class FarmAnimal : public Object {
	private:
  		pair<int,int> position; //Atribut posisi
  		bool isHungry = false; //Atribut menandakan FarmAnimal sudah makan atau belum
  		int timeUntilDead = 100; //Atribut menandakan waktu sebelum FarmAnimal mati.
  		int timeUntilHungry = 100;// Atribut menandakan waktu sebelum FarmAnimal lapar.
  		bool isProductProduced = false; //Atribut menandakan
      string name = ""; //Atribut nama dari FarmAnimal

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
  		pair<int,int> getPosition(); //Mendapatkan position
  		int getTimeUntilDead(); //Mendapat waktu sebelum hewan mati
  		int getTimeUntilHungry(); //Mendapat waktu sebelum hewan lapar
  		bool getIsProductProduced(); //Mendapat apakah produk sudah diproduksi
      string getName(); //Mendapat nama dari FarmAnimal

  		//Setter
  		void setPosition(pair<int,int> _position); //Menge-set posisi FarmAnimal
  		void setTimeUntilDead(int _timeUntilDead); //Menge-set waktu sebelum hewan mati
  		void setTimeUntilHungry(int _timeUntilHungry); //Menge-set waktu sebelum hewan lapar
  		void setIsProductProduced(bool _isProductProduced); //Menge-set apakah produk sudah diproduksi
      void setName(string _name); //Menge-set nama dari FarmAnimal

      bool isHungry(){
        return (timeUntilHungry == 0); //Method untuk mengembalikan apakah hewan dalam keadaan lapar
      }

  		void eat(); //Method untuk makan rumput di tempat hewan itu berdirI

  		//Bergerak
  		void move(DirectionType direction, LinkedList<Cell> map);


  		//Method untuk mengupdate keadaan animal
  		//Jika isHungry = True, timeUntilDead = timeUntilDead-1
  		//Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
  		void updateCondition();
};
#endif

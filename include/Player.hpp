/**
 * Nama File : Player.hpp
 * Tanggal   : 19 Maret 2019
 * Deskripsi : Kelas yang berkaitan dengan objek Player
 */

#ifndef PLAYER_HPP
#define PLAYER_HPP

#include <string>
#include "Object.hpp"
#include "Product.hpp"
#include "Cell.hpp"
#include "Land.hpp"
#include "FarmAnimal.hpp"
#include "LinkedList.hpp"

#define MAX_WATER 100
#define MAX_INVENTORY 10

using namespace std;

//Kelas ini merepresentasikan pemain.
class Player : public Object{
public:
		// Constructor dengan parameter nama pemain, jumlah air, dan jumlah uang.
		Player(string _name, int _water, double _uang, pair<int,int> _position, LinkedList<LinkedList<Cell*> *>* _worldMap);

		// Destructor karena ada pointer di atribut.
		~Player();

		// getter
		/**
		 * Mengembalikan nilai dari Atribut Name
		 */
		string getName();
		/**
		 * Mengembalikan nilai dari Atribut Water
		 */
		int getWater();
		/**
		 * Mengembalikan nilai dari Atribut Inventory
		 */
		LinkedList <Product *> getInventory();
		/**
		 * Mengembalikan nilai dari Atribut Uang
		 */
		double getUang();
		/**
		 * Mengembalikan nilai dari Atribut Position
		 */
		pair<int,int> getPosition();
		/**
		 * Mengembalikan nilai dari Atribut Count / Jumlah Produk
		 */
		int getCount(Product* _product);

		// setter
		/**
		 * Mengeset nilai dari Atribut Name
		 */
		void setName(string _name);
		/**
		 * Mengeset nilai dari Atribut Water
		 */
		void setWater(int _water);
		/**
		 * Menambah barang ke dalam inventory.
		 */
		void addInventory(Product* _barang);
		/**
		 * Mengeset nilai dari Atribut Uang
		 */
		void setUang(double _uang);
		/**
		 * Mengeset nilai dari Atribut Position
		 */
		void setPosition(pair<int,int> _position);

		// command
		/**
		 * Fungsi talk berguna untuk ngobrol hewan.
		 * Hewan yang diajak ngobrol, adalah hewan
		 * yang berada di depan player.
		 */
		void talk();
		/**
		 * Fungsi interact berguna untuk melakukan
		 * interaksi dengan objek objek yang ada.
		 * Efek Interaksi bergantung pada objek yang dikenai.
		 */
		void interact();
		/*
			Fungsi kosong dikarenakan terdapat virtual method interact
		*/
		void interact(Player *_p);
		/**
		 * Fungsi kill berguna untuk menyembelih hewan
		 * hewan dalam kategori MeatProducing.
		 */
		void kill();
		/**
		 * Fungsi grow berguna untuk menumbuhkan rumput
		 * pada land yang dikenai, agar bisa dimakan oleh
		 * Hewan yang berada pada land tersebut.
		 */
		void grow();
		/**
		 * Fungsi Move berguna untuk mengubah posisi dari
		 * player sesuai dengan direction yang diberikan.
		 */
		void move(DirectionType direction);
		/*
			Mengambil cell di hadapan pemain
		*/
		Cell* getCellInFront();
		/*
			Mengubah arah hadap pemain
		*/
		void changeDirection(DirectionType newDirection);	
	protected:
	 	//Nama pemain.
		string player_name;
		//Kapasitas air.
		int water;
		//Inventori pemain.
    	LinkedList <Product*> inventory;
		//Uang pemain.
		double uang;
		//Posisi pemain.
		pair<int,int> position;
		//Arah hadap pemain
		DirectionType direction;
		//Menyimpan worldmap
		LinkedList<LinkedList<Cell*> *>* worldMap;
};

#endif

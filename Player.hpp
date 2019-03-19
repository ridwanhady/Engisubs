/**
 * Nama File : Player.hpp
 * Tanggal   : 19 Maret 2019
 * Deskripsi : Kelas yang berkaitan dengan objek Player
 */

#ifndef PLAYER_HPP
#define PLAYER_HPP

#include <string>
#include "Product.hpp"
#include "LinkedList.hpp"

#define MAX_WATER 100
#define MAX_INVENTORY 10

using namespace std;

class Player : public Object{
	public:
		// ctor tanpa parameter
		Player();

		// ctor dengan parameter
		Player(string _name, int _water, LinkedList <Product> _inventory, double _uang);

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
		LinkedList <Product> getInventory();
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
		int getCount(Product _product);

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
		 * Mengeset nilai dari Atribut Inventory
		 */
		void setInventory(LinkedList <Product> _tas);
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
		void move(DirectionType direction, LinkedList<Cell>);
	private:
		string player_name; //nama pemain
		int water;	    //kapasitas air
    	LinkedList <Product> inventory; //tas/inventory
		double uang;	    //uang pemain
		pair<int,int> position; //Posisi pemain

};

#endif

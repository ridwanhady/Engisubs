/**
 * Nama File : Player.hpp
 * Tanggal   : 19 Maret 2019
 * Deskripsi : Kelas yang berkaitan dengan objek Player
 */
#include <iostream>

//Kelas ini merepresentasikan pemain.
#include "Player.hpp"

bool isValid(pair<int,int> pos, int n, int m){
	Cell *targetCell = worldMap.get(pos.first).get(pos.second);
	if(!targetCell->isWalkable() or targetCell->isOccupied() or pos.first < 0 or pos.first >= n or pos.second < 0 or pos.second >= m){
		return false;
	}
	return true;
}


	// Constructor dengan parameter nama pemain, jumlah air, dan jumlah uang, beserta posisi
Player::Player(string _name, int _water, double _uang, pair<int,int> _position): Object('P'){
	setName(_name);
	setWater(_water);
	setUang(_uang);
	setPosition(_position);
	objectType = PLAYER;
}


// Destructor karena ada pointer di atribut.
// Kemungkinan memory leak dari player, belum bener.
Player::~Player(){
	//Panggil desktruktor linkedlist
}

// getter
/**
 * Mengembalikan nilai dari Atribut Name
 */
string Player::getName() {
	return player_name;
}


/**
 * Mengembalikan nilai dari Atribut Water
 */
int Player::getWater() {
	return water;
}

/**
 * Mengembalikan nilai dari Atribut Inventory
*/
LinkedList<Product*> Player::getInventory(){
	return inventory;
}

/**
 * Mengembalikan nilai dari Atribut Uang
*/
double Player::getUang(){
	return uang;
}

/**
 * Mengembalikan nilai dari Atribut Position
*/

pair<int,int> Player::getPosition(){
	return position;
}

/**
 * Mengembalikan nilai dari Atribut Count / Jumlah Produk
*/

int Player::getCount(Product* _product){
	return inventory.count(_product);
}

// setter
/**
 * Mengeset nilai dari Atribut Name
*/

void Player::setName(string _name){
	player_name = _name;
}

/**
 * Mengeset nilai dari Atribut Water
 */
void Player::setWater(int _water) {
	water = _water;
}

/**
 * Menambah barang ke dalam inventory.
 */

void Player::addInventory(Product* _barang){
	inventory.add(_barang);
}

/**
 * Mengeset nilai dari Atribut Uang
 */

void Player::setUang(double _uang){
	uang = _uang;
}

/**
 * Mengeset nilai dari Atribut Position
 */

void Player::setPosition(pair<int,int> _position){
	position = _position;
}

// command
/**
 * Fungsi talk berguna untuk ngobrol hewan.
 * Hewan yang diajak ngobrol, adalah hewan
 * yang berada di depan player.
 */
 void Player::talk() {
	 cout << "Hello" << endl;
 }

/**
 * Fungsi interact berguna untuk melakukan
 * interaksi dengan objek objek yang ada.
 * Efek Interaksi bergantung pada objek yang dikenai.
 */
void Player::interact(Player *_p){

}

/**
	* Fungsi kill berguna untuk menyembelih hewan
	* hewan dalam kategori MeatProducing.
	*/
void Player::kill() {

}

/**
	* Fungsi grow berguna untuk menumbuhkan rumput
	* pada land yang dikenai, agar bisa dimakan oleh
	* Hewan yang berada pada land tersebut.
	*/

void Player::grow(){
	try{

	} catch (Exception &e){

	}
}

/**
	* Fungsi Move berguna untuk mengubah posisi dari
	* player sesuai dengan direction yang diberikan.
	*/
void Player::move(DirectionType direction, DirectionType direction) {
	int di[4] = {-1,1,0,0};
	int dj[4] = {0,0,1,-1};

	if(isValid(Position.first+di[direction], position.second+dj[direction], worldMap)){

	}
}

Cell* getCellInFront(LinkedList<LinkedList<Cell*>>* worldMap){
	
}

void changeDirection(DirectionType newDirection){
	direction = newDirection;
}
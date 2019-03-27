/**
 * Nama File : Player.hpp
 * Tanggal   : 19 Maret 2019
 * Deskripsi : Kelas yang berkaitan dengan objek Player
 */

//Kelas ini merepresentasikan pemain.
#include "Player.hpp"

	// Constructor dengan parameter nama pemain, jumlah air, dan jumlah uang, beserta posisi
Player::Player(string _name, int _water, double _uang, pair<int,int> _position): Object(PLAYER,'P'): objectType(PLAYER), objectSymbol('P') {
	setName(_name);
	setWater(_water);
	setUang(_uang);
	setPosition(_position);
}


// Destructor karena ada pointer di atribut.
// Kemungkinan memory leak dari player, belum bener.
Player::~Player(){
	typename vector<Product*>::iterator itr = inventory.begin();
	if (itr != inventory.end()){
			data.erase(itr);
	}
}

// getter
/**
 * Mengembalikan nilai dari Atribut Name
 */
string Player::getName() {
	return name;
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
LinkedList<Product> Player::getInventory(){
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
	name = _name;
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
void Player::interact(){

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

}

/**
	* Fungsi Move berguna untuk mengubah posisi dari
	* player sesuai dengan direction yang diberikan.
	*/
void Player::move(DirectionType direction, LinkedList<Cell>) {

}

/**
 * Nama File : Player.hpp
 * Tanggal   : 19 Maret 2019
 * Deskripsi : Kelas yang berkaitan dengan objek Player
 */
#include <iostream>

//Kelas ini merepresentasikan pemain.
#include "../include/Player.hpp"
#include "../include/Facility.hpp"
#include "../include/MeatProducing.hpp"
#include <stdexcept>

using namespace std;

bool isValid(pair<int,int> pos, LinkedList<LinkedList<Cell*> *>* worldMap){
	int n = worldMap->size();
	int m = (worldMap->get(0))->size();
	if(pos.first < 0 or pos.first >= n or pos.second < 0 or pos.second >= m){
		return false;
	}
	Cell *targetCell = worldMap->get(pos.first)->get(pos.second);
	if(!targetCell->isWalkable()){
		return false;
	}
	Land *targetLand = dynamic_cast<Land*>(targetCell);
	if(targetLand->isOccupied())return false;
	return true;
}


	// Constructor dengan parameter nama pemain, jumlah air, dan jumlah uang, beserta posisi
Player::Player(string _name, int _water, double _uang, pair<int,int> _position, LinkedList<LinkedList<Cell*> *>* _worldMap): Object('P'){
	setName(_name);
	setWater(_water);
	setUang(_uang);
	setPosition(_position);
	objectType = PLAYER;
	worldMap = _worldMap;
}


// Destructor karena ada pointer di atribut.
// Kemungkinan memory leak dari player, belum bener.
Player::~Player(){
	//Panggil desktruktor linkedlist
	delete worldMap;
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
	Cell *targetCell = getCellInFront();
	if(targetCell->isWalkable()){
		Land *targetLand = dynamic_cast<Land*>(targetCell);
		if(targetLand->isOccupied()){
			FarmAnimal *targetAnimal = dynamic_cast<FarmAnimal*>(targetLand->getObjectHere());
			targetAnimal->talk();
			return;
		}
	} 
	throw logic_error("Tidak ada hewan disitu");
 }

/**
 * Fungsi interact berguna untuk melakukan
 * interaksi dengan objek objek yang ada.
 * Efek Interaksi bergantung pada objek yang dikenai.
 */
void Player::interact(){
	Cell *targetCell = getCellInFront();
	if(targetCell != NULL){
		if(targetCell->isWalkable()){
			cout << "Anda menjalankan fungsi Interact" << endl;
			Land *targetLand = dynamic_cast<Land*>(targetCell);
			if(targetLand->getObjectHere() != NULL){
				targetLand->getObjectHere()->interact(this);
				//cout << "INTERACT DIPANGGIL" << endl;
				return;
			}
		} else {
			cout << "FAC" << endl;
			Facility *targetFacility = dynamic_cast<Facility*>(targetCell);
			cout << "FAC2" << endl;
			targetFacility->interact(this);
			return;
		}
	}
	throw logic_error("Tidak ada object yang bisa dilakukan interact disitu");
}
/*
	Fungsi kosong dikarenakan terdapat virtual method interact
*/
void Player::interact(Player *_p){

}

/**
	* Fungsi kill berguna untuk menyembelih hewan
	* hewan dalam kategori MeatProducing.
	*/
void Player::kill(LinkedList<FarmAnimal*> &farmAnimalList) {
	Cell *targetCell = getCellInFront();
	if(targetCell != NULL and targetCell->isWalkable()){
		Land *targetLand = dynamic_cast<Land*>(targetCell);
		if(targetLand->isOccupied()){
			FarmAnimal *targetAnimal = dynamic_cast<FarmAnimal*>(targetLand->getObjectHere());
			if(targetAnimal->isKillable()){
				farmAnimalList.remove(farmAnimalList.get(farmAnimalList.findElement(targetAnimal)));
				MeatProducing *m = dynamic_cast<MeatProducing*> (targetAnimal);
				m->produceMeat(*this);
				delete targetAnimal;
				targetLand->setObjectHere(NULL);
				return;
			}
		}
	} 
	throw logic_error("Tidak ada hewan yang bisa disembelih disitu");
}

/**
	* Fungsi grow berguna untuk menumbuhkan rumput
	* pada land yang dikenai, agar bisa dimakan oleh
	* Hewan yang berada pada land tersebut.
	*/

void Player::grow(){
	Cell *targetCell = worldMap->get(position.first)->get(position.second);
	Land *targetLand = dynamic_cast<Land*>(targetCell);
	if (!targetLand->isGrown()) {
		if (water > 0){
			targetLand->grow();
			water--;
		} else{
			throw logic_error("Air Anda tidak cukup");
		}
	} else {
		throw logic_error("Sudah ada Rumput di Land ini, mau dijadiin Pohon?");
	}
}

/**
	* Fungsi Move berguna untuk mengubah posisi dari
	* player sesuai dengan direction yang diberikan.
	*/
void Player::move(DirectionType direction) {
	int di[4] = {-1,1,0,0};
	int dj[4] = {0,0,1,-1};
	pair<int,int> targetPosition = {position.first+di[direction], position.second+dj[direction]};
	if(isValid(targetPosition, worldMap)){
		Land *currentLand = dynamic_cast<Land*>(worldMap->get(position.first)->get(position.second));
		currentLand->setObjectHere(NULL);
		position = {position.first+di[direction], position.second+dj[direction]};
		currentLand = (Land*)worldMap->get(position.first)->get(position.second);
		currentLand->setObjectHere(this);
		this->direction = direction;
	} else {
		//cout<<"Langkah tidak valid"<<endl;
		throw logic_error("Langkah tidak valid");
	}
}

Cell* Player::getCellInFront(){
	int di[4] = {-1,1,0,0};
	int dj[4] = {0,0,1,-1};
	pair<int,int> targetPosition = {position.first+di[direction], position.second+dj[direction]};
	if(targetPosition.first < 0 || targetPosition.first >= worldMap->size() || targetPosition.second < 0 || targetPosition.second >= worldMap->get(0)->size()){
		return NULL;
	}
	return worldMap->get(targetPosition.first)->get(targetPosition.second);
}

void Player::changeDirection(DirectionType newDirection){
	direction = newDirection;
}
#include "Truck.hpp"
#include "Product.hpp"
//Constructor, menginisialisasi posisi
Truck::Truck(pair<int,int> _position) : Facility(_position){
	setNotUsableTurns(0);
}
/**
 * Interact() berguna untuk berinteraksi dengan 'Truck'.
 * Berinteraksi dengan 'Truck' akan menjual semua barang
 * yang ada di Inventory player, dan menambah uang pemain
 * sejumlah harga barang - barang tersebut.
 * Setelah interact digunakan, Interact tidak akan bisa
 * digunakan untuk sementara waktu.
 */
void Truck::interact(Player* _p){
	LinkedList <Product *> inventTemp = _p->getInventory();
	for(int i = 0; i < inventTemp.size(); i++){
		_p->setUang(_p->getUang() + inventTemp.get(i)->getPrice());
	}
	//Todo: Delete inventory
	_p->getInventory().removeAll();
}


//Getter
/**
 * setNotUsableTurns akan mengubah nilai dari notUsableTurn menjadi
 * sebesar nut.
 */
void Truck::setNotUsableTurns(int nut){
	notUsableTurns = nut;
}
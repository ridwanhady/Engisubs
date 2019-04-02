#include "Well.hpp"

//Constructor, menginisialisasi posisi
Well::Well(pair<int,int> _position) : Facility(_position){

}
/**
 * Interact berguna untuk berinteraksi dengan 'Well'.
 * Berinteraksi dengan 'Well' akan menambah persediaan
 * 'Water' yang dimiliki hingga mencapai maksimal.
 */
void Well::interact(Player* _p){
	_p->setWater(MAX_WATER);
}
#include "Mixer.hpp"
#include "Game.hpp"
#include "SideProduct.hpp"
#include "Player.hpp"
#include <iostream>
using namespace std;

//Constructor, menginisialisasi posisi
Mixer::Mixer(pair<int,int> _position) : Facility(_position){

}

//Implementasi virtual interact()
void interact(Player* _p){
	//minta input
	int idxInventory_1, idxInventory_2, idxSideProd;
	bool isIdx1Valid, isIdx2Valid, isIdxSideProdValid, isFarmProduct;
	bool isFound;

	//Panggil static dari Game dilakukan
	LinkedList<ObjectType> daftarSideProduct = Game::getDaftarSideProduct();

	cout << "Masukkan indeks inventori (dari 0 - size)" << endl;
	cin >> idxInventory_1;
	cout << "Masukkan indeks inventori kedua (dari 0 - size)" << endl;
	cin >> idxInventory_2;
	//Cek apakah indeks pertama dan kedua valid;

	isIdx1Valid = (idxInventory_1 >= 0  && idxInventory_1 < (_p)->getInventory().size());
	isIdx2Valid = (idxInventory_2 >= 0  && idxInventory_2 < (_p)->getInventory().size());

	if (isIdx1Valid && isIdx2Valid){
		//Jika valid, dapatkan ProductType, ObjectType, serta Price.
		//Perhatikan bahwa (_p)->getInventory().get(idxInventory_1) merupakan tipe data Product*

		//Cek ProductType: Mixer akan berhasil kalau tipe dari ProductType adalah FARMPRODUCT
		isFarmProduct = ( ((_p)->getInventory().get(idxInventory_1))->getProductType() == FARMPRODUCT) && ( ((_p)->getInventory().get(idxInventory_2))->getProductType() == FARMPRODUCT) ;
		if (isFarmProduct) {
			cout << "Silakan masukkan indeks SideProduct yang anda mau!" << endl;
			cin >> idxSideProd;
			isIdxSideProdValid = (idxSideProd >= 0 && idxSideProd < daftarSideProduct);
			//Cek apakah indeks untuk linkedList Resep valid atau tidak.
			if (isIdxSideProdValid) {
				if (daftarSideProduct.get(idxSideProd) == CHEESE){
					Cheese::InitResepCheese();
					isFound = Cheese::resep.find(daftarSideProduct.get(idxSideProd));
					if (isFound != -1) {
						cout << "Resep tidak ditemukan!" << endl;
					} else {
						
					}
				}
			} else {
				cout << "Indeks yang Anda masukkan tidak valid." << endl;
			}

		} else {
			cout << "Product yang dibuat haruslah product langsung dari HEWAN!" << endl;
		}
		
	} else {
		cout << "Indeks yang Anda masukkan tidak valid." << endl;
	}
		
}
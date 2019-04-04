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
	int idxInventory_1, idxInventory_2, idxSideProd, idxResep;
	bool isIdx1Valid, isIdx2Valid, isIdxSideProdValid, isFarmProduct;
	FarmProductType idx1_farmProductType, idx2_farmProductType;
	bool isFoundIdx1 = false;
	bool isFoundIdx2 = false;

	//Panggil static dari Game dilakukan
	LinkedList<ObjectType> daftarSideProduct = Game::getProduct();

	cout << "Masukkan indeks inventori (dari 0 - size)" << endl;
	cin >> idxInventory_1;
	cout << "Masukkan indeks inventori kedua (dari 0 - size)" << endl;
	cin >> idxInventory_2;
	//Cek apakah indeks pertama dan kedua valid;

	isIdx1Valid = (idxInventory_1 >= 0  && idxInventory_1 < (_p)->getInventory().size());
	isIdx2Valid = (idxInventory_2 >= 0  && idxInventory_2 < (_p)->getInventory().size());

	if (isIdx1Valid && isIdx2Valid && idxInventory_1 != idxInventory_2){
		//Jika valid, dapatkan ProductType, ObjectType, serta Price.
		//Perhatikan bahwa (_p)->getInventory().get(idxInventory_1) merupakan tipe data Product*

		//Cek ProductType: Mixer akan berhasil kalau kedua indeks mengembalikan FARMPRODUCT
		isFarmProduct = ( ((_p)->getInventory().get(idxInventory_1))->getProductType() == FARMPRODUCT) && ( ((_p)->getInventory().get(idxInventory_2))->getProductType() == FARMPRODUCT) ;
		if (isFarmProduct) {
			//Jika SideProduct yang dipilih benar (CHEESE, EKADO, STEAK, dan MAYONAISE )
			cout << "Silakan masukkan indeks SideProduct yang anda mau!" << endl;
			cin >> idxSideProd; isIdxSideProdValid = (idxSideProd >= 0 && idxSideProd < daftarSideProduct.size());

			//Cek apakah indeks untuk linkedList Resep valid atau tidak.
			if (isIdxSideProdValid) {
				if (daftarSideProduct.get(idxSideProd) == CHEESE){
					//Cari resep yang digunakan untuk membuat cheese
					for (idxResep = 0 ; idxResep < Cheese::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep CHEESE
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_1))->getObjectType()) == Cheese::getResepwithIdx(idxResep)) {
							//Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
							idx1_farmProductType = Cheese::getResepwithIdx(idxResep);
							isFoundIdx1 = true;
							break;
						}
					}

					for (idxResep = 0 ; idxResep < Cheese::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep CHEESE
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_2))->getObjectType()) == Cheese::getResepwithIdx(idxResep)) {
							//Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
							if (idx1_farmProductType != Cheese::getResepwithIdx(idxResep)) {
								isFoundIdx2 = true;
								break;
							}
						}
					}

					if (isFoundIdx1 && isFoundIdx2) {
						//Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
						( (_p)->getInventory() ).remove( ((_p)->getInventory().get(idxInventory_1)));
						( (_p)->getInventory() ).remove( ((_p)->getInventory().get(idxInventory_2)));

						//Tambahkan Cheese pada Inventori:
						//Construct newCheese
						( (_p)->getInventory() ).add(new Cheese(CHEESE_PRICE, SIDEPRODUCT, CHEESE, 'C'));

						cout << "MEMBUAT CHEESE BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
					} else {
						cout << "Gagal membuat product karena dua tipe sama atau tidak sesuai tipe" << endl;
					}
				} else if (daftarSideProduct.get(idxSideProd) == STEAK){
					//Cari resep yang digunakan untuk membuat cheese
					for (idxResep = 0 ; idxResep < Steak::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep STEAK
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_1))->getObjectType()) == Steak::getResepwithIdx(idxResep)) {
							//Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
							idx1_farmProductType = Steak::getResepwithIdx(idxResep);
							isFoundIdx1 = true;
							break;
						}
					}

					for (idxResep = 0 ; idxResep < Steak::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep STEAK
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_2))->getObjectType()) == Steak::getResepwithIdx(idxResep)) {
							//Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
							if (idx1_farmProductType != Steak::getResepwithIdx(idxResep)) {
								isFoundIdx2 = true;
								break;
							}
						}
					}

					if (isFoundIdx1 && isFoundIdx2) {
						//Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
						( (_p)->getInventory() ).remove( ((_p)->getInventory().get(idxInventory_1)));
						( (_p)->getInventory() ).remove( ((_p)->getInventory().get(idxInventory_2)));

						//Tambahkan Steak pada Inventori:
						//Construct newSteak
						( (_p)->getInventory() ).add(new Steak(STEAK_PRICE, SIDEPRODUCT, STEAK, 'S'));

						cout << "MEMBUAT STEAK BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
					} else {
						cout << "Gagal membuat product karena dua tipe sama atau tidak sesuai tipe" << endl;
					}
				} 


			} else {
				cout << "Indeks yang Anda masukkan tidak valid atau sama." << endl;
			}

		} else {
			cout << "Product yang dibuat haruslah product langsung dari HEWAN!" << endl;
		}
		
	} else {
		cout << "Indeks yang Anda masukkan tidak valid." << endl;
	}
		
}


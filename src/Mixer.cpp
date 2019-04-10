#include "../include/Mixer.hpp"
#include "../include/Game.hpp"
#include "../include/SideProduct.hpp"
#include "../include/Player.hpp"
#include <iostream>
using namespace std;

//Constructor, menginisialisasi posisi
Mixer::Mixer(pair<int,int> _position) : Facility(_position){
	initObject(MIXER, 'M');
}

//Implementasi virtual interact()
void Mixer::interact(Player* _p){
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
						_p->inventory.remove( _p->inventory.get(idxInventory_1));
						_p->inventory.remove( _p->inventory.get(idxInventory_2));

						//Tambahkan Cheese pada Inventori:
						//Construct newCheese
						_p->inventory.add(new Cheese(CHEESE_PRICE));

						cout << "MEMBUAT CHEESE BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
					} else {
						cout << "Gagal membuat product karena dua tipe sama atau tidak sesuai tipe" << endl;
					}
				} else if (daftarSideProduct.get(idxSideProd) == STEAK){
					//Cari resep yang digunakan untuk membuat STEAK
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
						_p->inventory.remove( _p->inventory.get(idxInventory_1));
						_p->inventory.remove( _p->inventory.get(idxInventory_2));

						//Tambahkan Steak pada Inventori:
						//Construct newSteak
						_p->inventory.add(new Steak(STEAK_PRICE));

						cout << "MEMBUAT STEAK BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
					} else {
						cout << "Gagal membuat product karena dua tipe sama atau tidak sesuai tipe" << endl;
					}
				} else if (daftarSideProduct.get(idxSideProd) == EKADO){
					//Cari resep yang digunakan untuk membuat EKADO
					for (idxResep = 0 ; idxResep < Ekado::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep EKADO
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_1))->getObjectType()) == Ekado::getResepwithIdx(idxResep)) {
							//Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
							idx1_farmProductType = Ekado::getResepwithIdx(idxResep);
							isFoundIdx1 = true;
							break;
						}
					}

					for (idxResep = 0 ; idxResep < Ekado::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep Ekado
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_2))->getObjectType()) == Ekado::getResepwithIdx(idxResep)) {
							//Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
							if (idx1_farmProductType != Ekado::getResepwithIdx(idxResep)) {
								isFoundIdx2 = true;
								break;
							}
						}
					}

					if (isFoundIdx1 && isFoundIdx2) {
						//Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
						_p->inventory.remove( _p->inventory.get(idxInventory_1));
						_p->inventory.remove( _p->inventory.get(idxInventory_2));

						//Tambahkan Ekado pada Inventori:
						//Construct newEkado
						_p->inventory.add(new Ekado(EKADO_PRICE));

						cout << "MEMBUAT EKADO BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
					} else {
						cout << "Gagal membuat product karena dua tipe sama atau tidak sesuai tipe" << endl;
					}
				} else if (daftarSideProduct.get(idxSideProd) == MAYONAISE){
					//Cari resep yang digunakan untuk membuat Mayonaise
					for (idxResep = 0 ; idxResep < Mayonaise::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep MAYONAISE
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_1))->getObjectType()) == Mayonaise::getResepwithIdx(idxResep)) {
							//Simpam FarmProductType pada idx1_farmProductType, sebagai validasi idxInventory_2
							idx1_farmProductType = Mayonaise::getResepwithIdx(idxResep);
							isFoundIdx1 = true;
							break;
						}
					}

					for (idxResep = 0 ; idxResep < Mayonaise::getResep().size() ; idxResep++) {
						//Kalau inventory yang dipilih pemain cocok dengan resep Mayonaise
						if (FarmProduct::getFarmProductType( ((_p)->getInventory().get(idxInventory_2))->getObjectType()) == Mayonaise::getResepwithIdx(idxResep)) {
							//Kalau tipenya berbeda (contoh : EGG dan MILK, bukan EGG dan EGG maupun MILK dan MILK )
							if (idx1_farmProductType != Mayonaise::getResepwithIdx(idxResep)) {
								isFoundIdx2 = true;
								break;
							}
						}
					}

					if (isFoundIdx1 && isFoundIdx2) {
						//Kalau dua duanya valid, HAPUS DUA BARANG TERSEBUT PADA INVENTORI.
						_p->inventory.remove( _p->inventory.get(idxInventory_1));
						_p->inventory.remove( _p->inventory.get(idxInventory_2));

						//Tambahkan Mayonaise pada Inventori:
						//Construct newMayonaise
						_p->inventory.add(new Mayonaise(MAYONAISE_PRICE));

						cout << "MEMBUAT MAYONAISE BERHASIL! Dua Barang dihilangkan dari inventori Anda!" << endl;
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


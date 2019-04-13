#ifndef _TRUCK_HPP
#define _TRUCK_HPP

#include "Facility.hpp"
#include "Player.hpp"

class Truck : public Facility{
    private:
        int notUsableTurns;
    public:
        //Constructor, menginisialisasi posisi
        Truck(pair<int,int> _position);
        /**
         * Interact() berguna untuk berinteraksi dengan 'Truck'.
         * Berinteraksi dengan 'Truck' akan menjual semua barang
         * yang ada di Inventory player, dan menambah uang pemain
         * sejumlah harga barang - barang tersebut.
         * Setelah interact digunakan, Interact tidak akan bisa
         * digunakan untuk sementara waktu.
         */
        void interact(Player* _p);
        
        /**
         * isUsable() akan mengembalikan True jika Truck bisa digunakan,
         * yaitu, bisa dikenai fungsi Interact().
         * Ditunjukan dengan value dari atribut notUsableTurns yang bernilai 0
         */
        bool isUsable(){
            return notUsableTurns == 0;
        }

        //Setter
        /**
         * getNotUsableTurns akan mengembalikan nilai dari atribut notUsableTurns.
         */
        int getNotUsableTurns(){
            return notUsableTurns;
        }

        //Getter
        /**
         * setNotUsableTurns akan mengubah nilai dari notUsableTurn menjadi
         * sebesar nut.
         */
        void setNotUsableTurns(int nut);
};

#endif

#ifndef _LINKEDLIST_HPP
#define _LINKEDLIST_HPP

#include <algorithm>
#include <vector>

template <class T>
/*
    Kelas LinkedList

    Kelas ini adalah kelas template yang merepresentasikan sebuah LinkedList menggunakan
    Vector dari STL-C++.
*/
class LinkedList{
    private:
        /*
            Vector yang menyimpan data.
        */
        vector<T> data;
    public:
        /*
            Fungsi find() mencari elemen pada LinkedList dan mengembalikan indeks dari
            elemen tersebut. Jika tidak ditemukan maka akan mengembalikan nilai -1.
        */
        int findElement(T _element){
            typename vector<T>::iterator itr = find(data.begin(), data.end(), _element);
            if (itr == data.end()){
                return -1;
            }
            return distance(data.begin(), itr);
        }

        /*
            Fungsi ini menghitung kemunculan elemen.
        */
        int count(T _element){
          typename vector<T>::iterator itr = data.begin();
          int countEl = 0;
          while (itr != data.end()){
            if ((*itr) == _element){
              countEl++;
            }
            itr++;
          }
          return countEl;
        }

        /*
            Fungsi isEmpty() mengembalikan boolean yang bernilai True jika LinkedList
            kosong, False jika tidak.
        */
        bool isEmpty(){
            return data.empty();
        }

        /*
            Fungsi add() menambahkan elemen baru ke ujung LinkedList.
        */
        void add(T _element){
            data.push_back(_element);
        }

        /*
            Fungsi remove() menghapus elemen dari LinkedList.
        */
        void remove(T _element){
            typename vector<T>::iterator itr = find(data.begin(), data.end(), _element);
            if (itr != data.end()){
                data.erase(itr);
            }
        }

        /*
            Fungsi get() mengembalikan elemen pada LinkedList dengan indeks ke _indeks.
        */
        T get(int _indeks){
            return data.at(_indeks);
        }

        int size(){
            return data.size();
        }
};

template <class T>
/*
    Kelas LinkedList

    Kelas ini adalah kelas template yang merepresentasikan sebuah LinkedList menggunakan
    Vector dari STL-C++.
*/
class LinkedList<T*>{
    private:
        /*
            Vector yang menyimpan data.
        */
        vector<T*> data;
    public:
        /*
            Fungsi find() mencari elemen pada LinkedList dan mengembalikan indeks dari
            elemen tersebut. Jika tidak ditemukan maka akan mengembalikan nilai -1.
        */
        ~LinkedList(){
            for (typename vector<T*>::iterator itr = data.begin(); itr != data.end(); itr++){
                delete (*itr);
            }
        }

        int findElement(T* _element){
            typename vector<T*>::iterator itr = find(data.begin(), data.end(), _element);
            if (itr == data.end()){
                return -1;
            }
            return distance(data.begin(), itr);
        }

        /*
            Fungsi ini menghitung kemunculan elemen.
        */
        int count(T* _element){
          typename vector<T*>::iterator itr = data.begin();
          int countEl = 0;
          while (itr != data.end()){
            if ((*itr) == _element){
              countEl++;
            }
            itr++;
          }
          return countEl;
        }

        /*
            Fungsi isEmpty() mengembalikan boolean yang bernilai True jika LinkedList
            kosong, False jika tidak.
        */
        bool isEmpty(){
            return data.empty();
        }

        /*
            Fungsi add() menambahkan elemen baru ke ujung LinkedList.
        */
        void add(T* _element){
            data.push_back(_element);
        }

        /*
            Fungsi remove() menghapus elemen dari LinkedList.
        */
        void remove(T* _element){
            typename vector<T*>::iterator itr = find(data.begin(), data.end(), _element);
            if (itr != data.end()){
                data.erase(itr);
            }
        }

        void removeAll(){
            for (typename vector<T*>::iterator itr = data.begin(); itr != data.end(); itr++){
                delete (*itr);
            }
        }

        /*
            Fungsi get() mengembalikan elemen pada LinkedList dengan indeks ke _indeks.
        */
        T* get(int _indeks){
            return data.at(_indeks);
        }

        int size(){
            return data.size();
        }
};

#endif

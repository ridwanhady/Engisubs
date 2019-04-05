#include "../include/FarmAnimal.hpp"
#include <iostream>

using namespace std;

int FarmAnimal::animalCount = 0;

/*
Constructor yang menerima parameter posisi, nama)
*/
FarmAnimal::FarmAnimal(){
    animalCount++;
}

void FarmAnimal::initializeFarmAnimal(pair<int,int> _position, string _name, Land *_landPos){
    position = _position;
    name = _name;
    landPos = _landPos;
}

/*
Destructor untuk mengurangi jumlah hewan.
*/
FarmAnimal::~FarmAnimal(){
    animalCount--;
}

//Getter

//Mendapatkan position
pair<int,int> FarmAnimal::getPosition(){
    return position;
}

//Mendapat waktu sebelum hewan mati
int FarmAnimal::getTimeUntilDead(){
    return timeUntilDead;
}

//Mendapat waktu sebelum hewan lapar
int FarmAnimal::getTimeUntilHungry(){
    return timeUntilHungry;
}

//Mendapat apakah produk sudah diproduksi
bool FarmAnimal::getIsProductProduced(){
    return isProductProduced;
}

//Mendapat nama dari FarmAnimal
string FarmAnimal::getName(){
    return name;
}

//Mendapat Land tempat hewan berada
Land* FarmAnimal::getLandPos(){
    return landPos;
}

//Setter

//Menge-set posisi FarmAnimal
void FarmAnimal::setPosition(pair<int,int> _position){
    position = _position;
}

//Menge-set waktu sebelum hewan mati
void FarmAnimal::setTimeUntilDead(int _timeUntilDead){
    timeUntilDead = _timeUntilDead;
}

//Menge-set waktu sebelum hewan lapar
void FarmAnimal::setTimeUntilHungry(int _timeUntilHungry){
    timeUntilHungry = _timeUntilHungry;
}

//Menge-set apakah produk sudah diproduksi
void FarmAnimal::setIsProductProduced(bool _isProductProduced){
    isProductProduced = _isProductProduced;
}

//Menge-set nama dari FarmAnimal
void FarmAnimal::setName(string _name){
    name = _name;
}

//Menge-set Land tempat hewan berada
void FarmAnimal::setLandPos(Land *_newLand){
    landPos = _newLand;
}

//Method untuk makan rumput di tempat hewan itu berdiri
void FarmAnimal::eat(){
    if ((*landPos).isGrown()){
        timeUntilHungry = TIME_UNTIL_HUNGRY_DEFAULT;
        (*landPos).ungrow();
    }
}

//Bergerak
void FarmAnimal::move(DirectionType direction, LinkedList<LinkedList<Cell*>*>* map){
    switch (direction){
        //Atas
        case UP:
            //Jika masih bisa ke atas
            if (position.first > 0){
                Cell* tempCell = ((*map).get(position.first - 1))->get(position.second);
                if ((*tempCell).isWalkable()){
                    Land* tempLand = dynamic_cast<Land*> (tempCell);
                    if (!(*tempLand).isOccupied()){
                        cout << "BERGERAK KE " << position.first - 1 << " " << position.second << endl;
                        landPos->setObjectHere(NULL);
                        landPos = tempLand;
                        landPos->setObjectHere(this);
                        position.first -= 1;
                    }
                }
            }
            break;
        //Bawah
        case DOWN:
            //Jika masih bisa ke bawah
            if (position.first < (*map).size() - 1){
                Cell* tempCell = ((*map).get(position.first + 1))->get(position.second);
                if ((*tempCell).isWalkable()){
                    Land* tempLand = dynamic_cast<Land*> (tempCell);
                    if (!(*tempLand).isOccupied()){
                        cout << "BERGERAK KE " << position.first + 1 << " " << position.second << endl;
                        landPos->setObjectHere(NULL);
                        landPos = tempLand;
                        landPos->setObjectHere(this);
                        position.first += 1;
                    }
                }
            }
            break;
        //Kiri
        case LEFT:
            //Jika masih bisa ke kiri
            if (position.second > 0){
                Cell* tempCell = ((*map).get(position.first))->get(position.second - 1);
                if ((*tempCell).isWalkable()){
                    Land* tempLand = dynamic_cast<Land*> (tempCell);
                    if (!(*tempLand).isOccupied()){
                        cout << "BERGERAK KE " << position.first << " " << position.second - 1 << endl;
                        landPos->setObjectHere(NULL);
                        landPos = tempLand;
                        landPos->setObjectHere(this);
                        position.second -= 1;
                    }
                }
            }
            break;
        //Kanan
        case RIGHT:
            //Jika masih bisa ke kanan
            if (position.second < (*map).get(position.first)->size() - 1){
                Cell* tempCell = ((*map).get(position.first))->get(position.second + 1);
                if ((*tempCell).isWalkable()){
                    Land* tempLand = dynamic_cast<Land*> (tempCell);
                    if (!(*tempLand).isOccupied()){
                        cout << "BERGERAK KE " << position.first << " " << position.second + 1 << endl;
                        landPos->setObjectHere(NULL);
                        landPos = tempLand;
                        landPos->setObjectHere(this);
                        position.second += 1;
                    }
                }
            }
            break;
    }
}


//Method untuk mengupdate keadaan animal
//Jika isHungry = True, timeUntilDead = timeUntilDead-1
//Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
void FarmAnimal::updateCondition(){
    if (isHungry())
        timeUntilDead--;
    else {
        if (timeUntilHungry > 0)
            timeUntilHungry--;
        else
            hungry = true;
    }
}
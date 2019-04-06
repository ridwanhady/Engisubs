#include "../include/Game.hpp"
#include <iostream>
#include <time.h>
using namespace std;

LinkedList<ObjectType> Game::daftarProduct;

bool Game::isValid(pair<int,int> pos){
	if(pos.first < 0 or pos.first >= n or pos.second < 0 or pos.second >= m){
		return false;
	}

	Cell *targetCell = cellList.get(pos.first)->get(pos.second);

	if (!targetCell->isWalkable()){
		return false;
	}
	Land *targetLand = dynamic_cast<Land*>(targetCell);
	if(targetLand->isOccupied()) return false;
	return true;
}

Game::Game(){
	srand(time(NULL));
	string namaPemain;

	//Init cell (Todo)
	//vector<vector<Cell*> > vc;
	for(int i = 0; i < n; i++){
		LinkedList<Cell*>* temp = new LinkedList<Cell*> ();
		for(int j = 0; j < m; j++){
			if(rand()%100 <= 90){
				int r = rand()%3;
				if (r == 0){
					temp->add(new Grassland({i,j},0));
				}else if (r == 1){
					temp->add(new Barn({i,j},0));
				}else {
					temp->add(new Coop({i,j},0));
				}
			} else {
				int r = rand()%3;
				if (r == 0){
					temp->add(new Truck({i,j}));
				}else if (r == 1){
					temp->add(new Mixer({i, j}));
				}else {
					temp->add(new Well({i, j}));
				}
			}
		}
		
		cellList.add(temp);
		//vc.push_back(temp);
	}
	//Init animal
	
	int cntAnimal = 8;
	while(cntAnimal--){
		pair<int,int> randPosition = {rand()%n, rand()%m};
		while(!isValid(randPosition)){
			randPosition = {rand()%n, rand()%m};
		}
		int randAnimal = rand()%6;
		if(randAnimal == 0){
			Chicken *x = new Chicken(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		} else if(randAnimal == 1){
			Bison *x = new Bison(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		} else if(randAnimal == 2){
			Dog *x = new Dog(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		} else if(randAnimal == 3){
			Platypus *x = new Platypus(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		} else if(randAnimal == 4){
			Pterodactyl *x = new Pterodactyl(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		} else {
			TRex *x = new TRex(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
			farmAnimalList.add(x);
			(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
		
		}
	}

	//Meminta nama pemain
	cout<<"Masukkan nama pemain"<<endl;
	cin>>namaPemain;

	//Menaruh player di posisi random
	pair<int,int> curPos = {rand()%n, rand()%m};
	while(!isValid(curPos)){
		curPos = {rand()%n, rand()%m};
	}
	mainPlayer = new Player(namaPemain, 10, 10, curPos, &cellList);
	dynamic_cast<Land*>(cellList.get(curPos.first)->get(curPos.second))->setObjectHere(mainPlayer);
	//Melakukkan inisialisasi daftarProduct hanya saat belum pernah ada instance game
	if(daftarProduct.size() == 0){
		daftarProduct.add(CHEESE);
		daftarProduct.add(EKADO);
		daftarProduct.add(MAYONAISE);
		daftarProduct.add(STEAK);
		Cheese::InitResep();
		Ekado::InitResep();
		Mayonaise::InitResep();
		Steak::InitResep();
	}
}

//Destructor.
Game::~Game(){
	delete mainPlayer;
}

//Memulai game.
void Game::startGame(){
	isGameStarted = true;
}

//Game loop, meminta command dari player dan mengupdate currentTime.
//Pada fungsi ini game berjalan.
void Game::gameLoop(){
	string command;
	while(isGameStarted and farmAnimalList.size() > 0){
		cout<< "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " << endl<<endl;
		showMap();
		cout<< "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " << endl<<endl;
		cout<<"Input: "; cin>>command;
		cout << endl;
		cout<< "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - " << endl;
		if(command == "HELP"){
			cout << endl;
			cout<<"Command yang tersedia:"<<endl;
			cout<<"UP,  DOWN,  RIGHT,  LEFT,  TALK,  INTERACT,  KILL,  GROW"<<endl;
			cout<<"Command untuk mengubah arah hadap player (Tidak akan menambah waktu bermain):"<<endl;
			cout<<"LU,  LD,  LL,  LR,  QUIT"<<endl;
		} else if(command == "UP"){
			mainPlayer->move(UP);
			updateGame();
		} else if(command == "DOWN"){
			mainPlayer->move(DOWN);
			updateGame();
		} else if(command == "RIGHT"){
			mainPlayer->move(RIGHT);
			updateGame();
		} else if(command == "LEFT"){
			mainPlayer->move(LEFT);
			updateGame();
		} else if(command == "TALK"){
			mainPlayer->talk();
			updateGame();
		} else if(command == "INTERACT"){
			mainPlayer->interact();
			updateGame();
		} else if(command == "KILL"){
			mainPlayer->kill(farmAnimalList);
			updateGame();
		} else if(command == "GROW"){
			mainPlayer->grow();
			updateGame();
		} else if(command == "LU"){
			mainPlayer->changeDirection(UP);
		} else if(command == "LD"){
			mainPlayer->changeDirection(DOWN);
		} else if(command == "LL"){
			mainPlayer->changeDirection(LEFT);
		} else if(command == "LR"){
			mainPlayer->changeDirection(RIGHT);
		} else if(command == "QUIT"){
			endGame();
		} else if(command == "SHOW") {
			cout << "Berikut adalah isi dari Inventori:" << endl;
			for (int i = 0 ; i < mainPlayer->getInventory().size() ; i ++) {
				cout << mainPlayer->getInventory().get(i)->getName() << ",";
			}
			cout << endl;
		} else {
			cout<<"Command tidak valid"<<endl;
		}
	}
	if(farmAnimalList.size() == 0){
		cout << "Sudah tidak ada hewan lagi di game"<<endl;
	}
}

//Mengupdate seluruh state game
void Game::updateGame(){
	//Mengupdate seluruh state animal
	//Urutan pengerjaan:
	//1. Makan
	//2. Update hungryBar
	//3. Pindah ke cell lain
	DirectionType dir[4] = {UP,DOWN,RIGHT,LEFT};
	int di[4] = {-1,1,0,0};
	int dj[4] = {0,0,1,-1};
	cout << "AYAM " << farmAnimalList.size() << endl;
	for(int i = 0; i < farmAnimalList.size(); i++){
		if(farmAnimalList.get(i) == NULL){
			farmAnimalList.remove(farmAnimalList.get(i));
			i--;
			continue;
		}
		if(farmAnimalList.get(i)->isHungry()){
			farmAnimalList.get(i)->eat();
		}
		farmAnimalList.get(i)->updateCondition();
		if(farmAnimalList.get(i)->getTimeUntilDead() == 0){
			FarmAnimal *temp = farmAnimalList.get(i);
			farmAnimalList.remove(farmAnimalList.get(i));
			delete temp;
			i--;
			continue;
		}
		//Melakukan randomisasi gerakan, jika muncul angka 4, maka hewan tidak akan bergerak
		int moveDirection;
		pair<int,int> curPos = farmAnimalList.get(i)->getPosition();
		cout << "HEWAN " << i << endl;
		do{
			moveDirection = rand()%5;
			if(moveDirection < 4 and isValid({curPos.first+di[moveDirection],curPos.second+dj[moveDirection]})){
				//Fungsi untuk gerak random
				farmAnimalList.get(i)->move(dir[moveDirection], &cellList);
				break;
			} else if(moveDirection == 4){
				cout<<"Berhenti"<<endl;
				break;
			}
		} while (!isValid({curPos.first+di[moveDirection],curPos.second+dj[moveDirection]}));

	}
	//Mengupdate seluruh state Truck
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			Cell *targetCell = cellList.get(i)->get(j);
			if(targetCell->getObjectType() == TRUCK){
				Truck *targetTruck = dynamic_cast<Truck*>(targetCell);
				targetTruck->setNotUsableTurns(max(0,targetTruck->getNotUsableTurns()-1));
			}
		}
	}
	currentTime++;
}

//Menyelesaikan game.
void Game::endGame(){
	isGameStarted = false;
}

void Game::showMap(){
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cellList.get(i)->get(j)->render();
			cout << "   ";
		}
		cout << endl << endl << endl;
	}
}

LinkedList<ObjectType> Game::getProduct(){
	return Game::daftarProduct;
}
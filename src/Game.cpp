#include "../include/Game.hpp"
#include <iostream>
#include <time.h>
using namespace std;

LinkedList<ObjectType> Game::daftarProduct;

bool Game::isValid(pair<int,int> pos){
	cout << "Maruf" << endl;
	if(pos.first < 0 or pos.first >= n or pos.second < 0 or pos.second >= m){
		cout << "Sandi" << endl;
		return false;
	}

	cout << "Bawaslu" << endl;
	Cell *targetCell = cellList.get(pos.first)->get(pos.second);
	cout << "Polri" << endl;

	if (!targetCell->isWalkable()){
		cout << "Aga" << endl;
		return false;
	}
	cout << "KP" << endl;
	Land *targetLand = dynamic_cast<Land*>(targetCell);
	cout << "KPU" << endl;
	if(targetLand->isOccupied()) return false;
	return true;
}

Game::Game(){
	srand(time(NULL));
	string namaPemain;

	//Init cell (Todo)
	//vector<vector<Cell*> > vc;
	for(int i = 0; i < n; i++){
		cout << "ADDO" << endl;
		LinkedList<Cell*>* temp = new LinkedList<Cell*> ();
		//vector<Cell*> temp;
		for(int j = 0; j < m; j++){
			cout << "ADDI" << endl;
			//temp.push_back(new Grassland({i,j},1));
			if(rand()%100 <= 90){
				temp->add(new Grassland({i,j},1));
			} else {
				temp->add(new Truck({i,j}));
			}
		}
		
		cout << "OO" << endl;
		cellList.add(temp);
		cout<<"CI "<< cellList.get(i)->size() <<endl;
		cout<<"CO "<< cellList.size()<<endl;
		//vc.push_back(temp);
	}
	cout<<"Done"<<endl;
	//Init animal
	
	int cntAnimal = 3;
	while(cntAnimal--){
		pair<int,int> randPosition = {rand()%n, rand()%m};
		cout << "Joko" << endl;
		while(!isValid(randPosition)){
			cout << "RAND" << endl;
			randPosition = {rand()%n, rand()%m};
		}
		cout << "Prabo" << endl;
		Chicken *x = new Chicken(randPosition, "Joko", dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)));
		farmAnimalList.add(x);
		(dynamic_cast<Land*>(cellList.get(randPosition.first)->get(randPosition.second)))->setObjectHere(x);
	}

	//Meminta nama pemain
	cout<<"Masukkan nama pemain"<<endl;
	cin>>namaPemain;

	//Menaruh player di posisi random
	pair<int,int> curPos = {rand()%n, rand()%m};
	while(!isValid(curPos)){
		curPos = {rand()%n, rand()%m};
	}
	mainPlayer = new Player(namaPemain, 10, 10, curPos);
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
	while(isGameStarted){
		showMap();
		cout<<"Input: "<<endl;
		cin>>command;
		if(command == "HELP"){
			cout<<"Command yang tersedia:"<<endl;
			cout<<"UP"<<endl;
			cout<<"DOWN"<<endl;
			cout<<"RIGHT"<<endl;
			cout<<"LEFT"<<endl;
			cout<<"TALK"<<endl;
			cout<<"INTERACT"<<endl;
			cout<<"KILL"<<endl;
			cout<<"GROW"<<endl;
			cout<<"Command untuk mengubah arah hadap player (Tidak akan menambah waktu bermain)"<<endl;
			cout<<"LU"<<endl;
			cout<<"LD"<<endl;
			cout<<"LL"<<endl;
			cout<<"LR"<<endl;
			cout<<"QUIT"<<endl;
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
			mainPlayer->kill();
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
		} else {
			cout<<"Command tidak valid"<<endl;
		}
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
	for(int i = 0; i < farmAnimalList.size(); i++){
		if(farmAnimalList.get(i)->isHungry()){
			farmAnimalList.get(i)->eat();
		}
		farmAnimalList.get(i)->updateCondition();
		//Melakukan randomisasi gerakan, jika muncul angka 4, maka hewan tidak akan bergerak
		int moveDirection;
		pair<int,int> curPos = farmAnimalList.get(i)->getPosition();
		do{
			moveDirection = rand()%5;
			if(moveDirection < 4){
				farmAnimalList.get(i)->move(dir[moveDirection], &cellList);
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
	cout << cellList.size() << endl;
	cout << cellList.get(0)->size() << endl;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cellList.get(i)->get(j)->render();
		}
		cout<<endl;
	}
}

LinkedList<ObjectType> Game::getProduct(){
	return Game::daftarProduct;
}
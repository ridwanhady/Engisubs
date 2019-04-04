#include "Game.hpp"
#include <iostream>
#include <time.h>
using namespace std;

bool isValid(pair<int,int> pos, int n, int m, LinkedList<LinkedList<Cell*>> cellList){
	Cell *targetCell = cellList.get(pos.first).get(pos.second);
	if(!targetCell->isWalkable() or pos.first < 0 or pos.first >= n or pos.second < 0 or pos.second >= m){
		return false;
	}
	Land *targetLand = (Land*)targetCell;
	if(targetLand->isOccupied()) return false;
	return true;
}

Game::Game(){
	srand(time(NULL));
	string namaPemain;

	//Init cell (Todo)
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			
		}
	}
	//Init animal
	//Todo

	//Meminta nama pemain
	cout<<"Masukkan nama pemain"<<endl;
	cin>>namaPemain;

	//Menaruh player di posisi random
	pair<int,int> curPos = {rand()%n, rand()%m};
	while(!isValid(curPos,n,m, cellList)){
		curPos = {rand()%n, rand()%m};
	}
	mainPlayer = new Player(namaPemain, 10, 10, curPos);

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
	//Todo: Mengupdate seluruh state animal
	//Todo: Mengupdate seluruh state object
	currentTime++;
}

//Menyelesaikan game.
void Game::endGame(){
	isGameStarted = false;
}

void Game::showMap(){
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cellList.get(i).get(j)->render();
		}
		cout<<endl;
	}
}
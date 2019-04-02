#include "Game.hpp"

Game::Game(){
	//Init animal
	//Init cell

	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			
		}
	}
	//Todo: Minta input buat minta nama
	//Todo: Check apakah posisi sekarang valid
	mainPlayer = new Player("Joni", 10, 10, {0,0});
}

//Destructor.
Game::~Game(){

}

//Memulai game.
void Game::startGame(){

}

//Game loop, meminta command dari player dan mengupdate currentTime.
//Pada fungsi ini game berjalan.
void Game::gameLoop(){

}

//Menyelesaikan game.
void Game::endGame(){

}
#ifndef _GAME_HPP
#define _GAME_HPP

#include "AnimalDependencies.hpp"
#include "CellDependencies.hpp"
#include "ProductDependencies.hpp"
#include "Player.hpp"

class Game{
	private:
		bool isGameStarted = false;
		int currentTime = 0;
		LinkedList<FarmAnimal*> farmAnimalList;
		LinkedList<LinkedList<Cell*>> cellList;
		Player* mainPlayer;
		int n = 10;
		int m = 10;
	public:
		//Constructor.
		Game();

		//Destructor.
		~Game();

		//Memulai game.
		void startGame();

		//Game loop, meminta command dari player dan memanggil updateGame.
		//Pada fungsi ini game berjalan.
		void gameLoop();

		//Mengupdate seluruh state game
		void updateGame();

		//Menyelesaikan game.
		void endGame();

		//Menampilkan map
		void showMap();
};

#endif
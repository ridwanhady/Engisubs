#ifndef _GAME_HPP
#define _GAME_HPP

#include "LinkedList.hpp"
#include "FarmAnimal.hpp"
#include "Cell.hpp"

class Game{
	private:
		bool isGameStarted = false;
		int currentTime = 0;
		LinkedList<FarmAnimal*> farmAnimalList;
		LinkedList<Cell*> cellList;
	public:
		//Constructor
		Game();

		//Memulai game.
		void startGame();

		//Game loop, meminta command dari player dan mengupdate currentTime.
		//Pada fungsi ini game berjalan.
		void gameLoop();

		//Menyelesaikan game.
		void endGame();
};

#endif
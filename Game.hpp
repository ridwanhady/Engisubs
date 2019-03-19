#ifndef _GAME_HPP
#define _GAME_HPP

class Game{
	private:
		bool isGameStarted = false;
		int currentTime = 0;
		LinkedList<FarmAnimal> farmAnimalList;
		LinkedList<Cell> cellList;
	public:
		Game();

		//Memulai game
		void startGame();
		//Game loop, meminta command dari player dan mengupdate currentTime
		void gameLoop();
		//Menyelesaikan game
		void endGame();
};

#endif
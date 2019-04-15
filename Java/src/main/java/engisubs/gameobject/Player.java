package main.java.engisubs.gameobject;

public class Player extends GameObject{
 	/**
 	 * Nama pemain
 	 */
	string player_name;
	/**
	 * Kapasitas air
	 */
	int water;
	/**
	 * Uang pemain
	 */
	double uang;
	/**
	 * Posisi pemain
	 */
	pair<int,int> position;
	/**
	 * Arah hadap pemain
	 */
	DirectionType direction;
	/**
	 * Menyimpan worldmap
	 */
	List<List<Cell>> worldMap;
    Player(String _name, int _water, double _uang, int x, int y, List<List<Cell>> _worldMap){
		setName(_name);
		setWater(_water);
		setUang(_uang);
		setPosition(x,y);
		initGameObject(PLAYER, 'P');
		worldMap = _worldMap;
	}
}
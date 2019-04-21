package engisubs.gameobject.farmanimal;

import engisubs.gameobject.Player;

public interface MeatProducing {
	/**
	 * Method untuk menghasilkan daging
	 * @param _p Reference dari player untuk melakukan penambahan inventory
	 */
    void produceMeat(Player _p);
}
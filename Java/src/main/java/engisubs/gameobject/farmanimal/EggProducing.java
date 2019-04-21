package engisubs.gameobject.farmanimal;

import engisubs.gameobject.Player;

public interface EggProducing {
	/**
	 * Method untuk menghasilkan telur
	 * @param _p Reference dari player untuk melakukan penambahan inventory
	 */
    void produceEgg(Player<?> _p);
}
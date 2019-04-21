package engisubs.gameobject.farmanimal;

import engisubs.gameobject.Player;

public interface MilkProducing {
	/**
	 * Method untuk menghasilkan susu
	 * @param _p Reference dari player untuk melakukan penambahan inventory
	 */
    void produceMilk(Player _p);
}
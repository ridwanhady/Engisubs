package engisubs.gameobject.cell.facility;

import java.util.*;

import engisubs.gameobject.Player;

public class Well extends Facility{
	/**
	 * Constructor dari Well
	 * @param  _position Posisi dari Well
	 * @return           Instance dari Well
	 */
    public Well(Map <String, Integer> _position){
      super(_position);
      initGameObject(GameObjectType.WELL, 'W');
    }
    /**
     * Melakukan interact dengan Well untuk mengisi air sampai penuh
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
      _p.setWater(10);
    }
  }

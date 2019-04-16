package engisubs.gameobject.cell.facility;

import java.util.*;

import engisubs.gameobject.Player;

public class Well extends Facility
  {
    public Well(Map <String, Integer> _position){
      super(_position);
      initGameObject(GameObjectType.WELL, 'W');
    }

    public void interact(Player _p){
      _p.setWater(100);
    }
  }

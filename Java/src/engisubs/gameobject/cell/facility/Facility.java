package engisubs.gameobject.cell.facility;

import engisubs.gameobject.GameObject;
import engisubs.gameobject.cell.*;
import java.util.*;

public abstract class Facility extends Cell
  {
  
  /**
  * Constructor, menginisialisasi posisi
  */
  public Facility(Map <String, Integer> _position)
    {
      super(_position);
    }
   
   /**
   * Facility tidak bisa dilangkahi
   */
   
   public boolean isWalkable()
    {
      return false;
    }
    
  }

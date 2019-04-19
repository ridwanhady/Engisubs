package engisubs.gameobject.cell.facility;

import java.util.Map;

import engisubs.gameobject.cell.Cell;

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

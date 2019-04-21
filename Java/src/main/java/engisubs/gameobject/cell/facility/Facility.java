package engisubs.gameobject.cell.facility;

import java.util.Map;

import engisubs.gameobject.cell.Cell;

public abstract class Facility extends Cell
  {
  
  /**
   * Constructor dari Facility
   * @param  _position Posisi dari Facility
   * @return           Instance dari Facility
   */
  public Facility(Map <String, Integer> _position)
    {
      super(_position);
    }
   
   /**
    * Abstract method dari Cell yang menunjukkan bahwa Facility tidak bisa dilangkahi
    * @return false
    */
   public boolean isWalkable()
    {
      return false;
    }
    
  }

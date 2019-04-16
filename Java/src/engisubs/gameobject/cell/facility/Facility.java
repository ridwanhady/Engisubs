package engisubs.gameobject.cell.facility;

import engisubs.gameobject.GameObject;
import engisubs.gameobject.cell.*;
import java.util.*;
public abstract class Facility extends Cell
  {
  
  /**
  * Constructor, menginisialisasi posisi
  */
  public Facility(int _positionX, int _positionY)
    {
    super(_positionX, _positionY);
    }
   
   /**
   * Facility tidak bisa dilangkahi
   */
   
   public bool isWalkable()
    {
    return false;
    }
    
  }

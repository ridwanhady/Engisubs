package engisubs.gameobject.cell.land;

import engisubs.gameobject.GameObject;
import engisubs.gameobject.cell.*;
import java.util.*;
public abstract class Land extends Cell{

    private boolean grown;
    private boolean occupied = false;
    private LandType landType;
    private GameObject objectHere;
    private char landSymbol[] = new char[]{'-', 'x', 'o'};
    private char grassSymbol[] = new char[] {'#', '@', '*'};

    public enum LandType {
        GRASSLAND,
        BARN,
        COOP
    };

    /**
     * Ctor dengan parameter
     */ 
    public Land(Map<String, Integer> _position, boolean _isGrown, LandType _landType) {
        super(_position);
        gameObjectType = GameObjectType.LAND;
        grown = _isGrown;
        if (grown){
            objectSymbol = grassSymbol[_landType.ordinal()];
        } else {
            objectSymbol = landSymbol[_landType.ordinal()];
        }
    }


    /**
     * Getter Object saat ini
     */
    public GameObject getObjectHere() {
        return objectHere;
    }
    
    /**
     * Getter LandType
     * @return LandType
     */
    public LandType getLandType(){
        return landType;
    }
    /**
     * Setter :Menambah/mengurangi object saat ini dan mengganti isOccupied
     */

    public void setObjectHere(GameObject _objectHere){
        objectHere = _objectHere;
        if(objectHere == null) 
            occupied = false;
        else
            occupied = true;
    }


    /**
     * Menumbuhkan rumput di cell
     */
    public void grow() {
        grown = true;
	    objectSymbol = grassSymbol[landType.ordinal()];
    }
    
    /**
     * Method yang mengecek apakah Land dapat dilangkahi.
     */
    public boolean isWalkable(){
        return true;
    }

    /**
     * Mengecek apakah terdapat rumput di cell ini
     */
    public boolean isGrown(){
        return grown;
    }

     
    /**
     * Mengecek apakah terdapat FarmAnimal atau Player disini
     */
    public boolean isOccupied(){
         return occupied;
    }

    /**
     *  Menghilangkan rumput di cell
     */
    public void ungrow(){
	    grown = false;
	    objectSymbol = landSymbol[landType.ordinal()];
    }

    public void render(){
        if (isOccupied()){
            System.out.print(objectHere.objectSymbol);
        } else {
            System.out.print(objectSymbol);
        }
    }
}








        

       

   
    
        
        







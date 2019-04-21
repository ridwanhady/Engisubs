package engisubs.gameobject.cell;
import engisubs.gameobject.*;

import java.util.*;

public abstract class Cell extends GameObject{
    private Map<String, Integer> currentPos = new HashMap<>();

    /** 
     * Konstruktor dari Cell dengan parameter.
     */

    public Cell(Map<String, Integer> _position) {
        //System.out.println("Cell");
        //System.out.println("Init " + _position.get("Row") + " " + _position.get("Col"));
        currentPos.put("Row", _position.get("Row"));
        //System.out.println("Cell A");
        currentPos.put("Col", _position.get("Col"));
        //System.out.println("Cell B");
    }

    /**
     * Method untuk mengecek apakah suatu petak dapat dilangkahi player atau tidak
     */
    public boolean isWalkable() {
        return false;
    }

    /**
     * Getter position
     * @return currentPos
     */
    public Map<String, Integer> getPosition(){
        return currentPos;
    }

    /**
     * Setter position
     * @param _newPosition currentPos yang baru
     */
    public void setPosition(Map<String, Integer> _newPosition) {
        currentPos.replace("Row", _newPosition.get("Row"));
        currentPos.replace("Col", _newPosition.get("Col"));
    }

}



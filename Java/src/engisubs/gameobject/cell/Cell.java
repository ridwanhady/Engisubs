package engisubs.gameobject.cell;
import engisubs.gameobject.*;

import java.util.*;

public abstract class Cell extends GameObject{
    private Map<String, Integer> currentPos;

    /** 
     * Konstruktor dari Cell dengan parameter.
     */

    public Cell(Map<String, Integer> _position) {
        currentPos.put("Row", _position.get("Row"));
        currentPos.put("Col", _position.get("Col"));
    }

    /**
     * Method untuk mengecek apakah suatu petak dapat dilangkahi player atau tidak
     */
    public boolean isWalkable() {
        return false;
    }

    /**
     * Getter
     */

    public Map<String, Integer> getPosition(){
        return currentPos;
    }

    /** 
     * Setter
     */
    public void setPosition(Map<String, Integer> _newPosition) {
        currentPos.replace("Row", _newPosition.get("Row"));
        currentPos.replace("Col", _newPosition.get("Col"));
    }

}



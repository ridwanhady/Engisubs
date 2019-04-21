package engisubs.gameobject.cell;
import engisubs.gameobject.*;

import java.util.*;

public abstract class Cell extends GameObject implements Comparable<Cell>{
    private Map<String, Integer> currentPos = new HashMap<>();

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

    public int compareTo(Cell c){
        if(currentPos == c.getPosition()){
            return 0;
        } else if(currentPos.get("Row") == c.getPosition().get("Row")){
            return currentPos.get("Col") > c.getPosition().get("Col") ? 1 : -1;
        } else {
            return currentPos.get("Row") > c.getPosition().get("Row") ? 1 : -1;
        }
    }
}



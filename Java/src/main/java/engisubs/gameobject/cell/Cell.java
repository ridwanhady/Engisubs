package main.java.engisubs.gameobject.cell;
import engisubs.gameobject.GameObject;

public abstract class Cell extends GameObject{
    protected int positionX;
    protected int positionY;

    /** 
     * Konstruktor dari Cell dengan parameter.
     */

    public Cell(int _positionX, int _positionY) {
        setPosition(_positionX, _positionY);
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

    public int getPositionX(){
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    /** 
     * Setter
     */
    public void setPosition(int _positionX, int _positionY) {
        positionX = _positionX;
        positionY = _positionY;
    }

}



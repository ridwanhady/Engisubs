package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.*;
import engisubs.gameobject.cell.land.*;

abstract public class FarmAnimal extends GameObject {
    protected static int animalCount = 0;
    protected Map <String, Integer> position = new HashMap<>();
    protected boolean hungry = false;
    protected int timeUntilDead = 10;
    protected int timeUntilHungry = 0;
    protected boolean isProductProduced = true;
    protected String name = "";
    protected Land landPos = null;
    protected boolean killable = false;
    /**
     * Inisialisasi informasi yang dibutuhkan oleh FarmAnimal
     * @param _position Posisi dari FarmAnimal
     * @param _name     Nama dari FarmAnimal
     * @param _landPos  Land dimana FarmAnimal berada
     */
    protected void initializeFarmAnimal(Map <String, Integer> _position, String _name, Land _landPos){
        position.put("Row", _position.get("Row"));
        position.put("Col", _position.get("Col"));
        name = _name;
        landPos = _landPos;
    }
    /**
     * Getter position
     * @return Map<String,Integer>
     */
    public Map <String, Integer> getPosition(){
        return position;
    }
    /**
     * Getter timeUntilDead
     * @return timeUntilDead
     */
    public int getTimeUntilDead(){
        return timeUntilDead;
    }
    /**
     * Getter timeUntilHungry
     * @return timeUntilHungry
     */
    public int getTimeUntilHungry(){
        return timeUntilHungry;
    }
    /**
     * Getter isProductProduced
     * @return isProductProduced
     */
    public boolean getIsProductProduced(){
        return isProductProduced;
    }
    /**
     * Getter name
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Getter landPos
     * @return landPos
     */
    public Land getLandPos(){
        return landPos;
    }
    /**
     * Getter isKillable
     * @return killable
     */
    public boolean isKillable(){
        return killable;
    }
    /**
     * Getter isHungry
     * @return hungry
     */
    public boolean isHungry(){
        return hungry;
    }
    /**
     * Abstract prosedur talk yang berbeda untuk setiap FarmAnimal
     */
    public abstract String talk();
    /**
     * Setter Position
     * @param _newPosition Posisi baru dari FarmAnimal
     */
    protected void setPosition(Map <String, Integer> _newPosition){
        position.replace("Row", _newPosition.get("Row"));
        position.replace("Col", _newPosition.get("Col"));
    }
    /**
     * Setter timeUntilDead
     * @param _timeUntilDead timeUntilDead yang baru dari FarmAnimal
     */
    protected void setTimeUntilDead(int _timeUntilDead){
        timeUntilDead = _timeUntilDead;
    }
    /**
     * Setter isProductProduced
     * @param _isProductProduced Nilai isProductProduced yang baru
     */
    protected void setIsProductProduced(boolean _isProductProduced){
        isProductProduced = _isProductProduced;
    }
    /**
     * Method makan bagi FarmAnimal
     */
    public void eat(){
        if (landPos.isGrown()) {
            //System.out.println("MAKAN VALID");
            timeUntilDead = 10;
            timeUntilHungry = 10;
            hungry = false;
            landPos.ungrow();
            setIsProductProduced(false);
        } else {
            //System.out.println("MAKAN TIDAK VALID");
        }
    }

    /**
     *  Method untuk mengupdate keadaan animal
     *  Jika isHungry = True, timeUntilDead = timeUntilDead-1
     *  Jika isHungry = False, timeUntilHungry = timeUntilHungry-1, dan jika timeUntilHungry = 0, isHungry = True
     */
    public void updateCondition(){
        if (isHungry()){
            timeUntilDead -= 1;
        }else {
            if (timeUntilHungry > 0)
                timeUntilHungry--;
            else {
                System.out.println("HUNGRY!");
                hungry = true;
            }
               
        }
    }
    /**
     * Method untuk menggerakan FarmAnimal
     * @param dir Direction yang dituju oleh FarmAnimal tersebut
     * @param map Peta dari game
     */
    public void move(DirectionType dir, List<LinkedList<Cell>> map){
        switch (dir){
            //Atas
            case UP:
                //Jika masih bisa ke atas
                if (position.get("Row") > 0){
                    Cell tempCell = (map.get(position.get("Row") - 1)).get(position.get("Col"));
                    if (tempCell.isWalkable()){
                        Land tempLand = (Land) tempCell;
                        if (!tempLand.isOccupied()){
                            //cout << "BERGERAK KE " << position.first - 1 << " " << position.second << endl;
                            landPos.setObjectHere(null);
                            landPos = tempLand;
                            landPos.setObjectHere(this);
                            position.replace("Row", position.get("Row") - 1);
                        }
                    }
                }
                break;
            //Bawah
            case DOWN:
                //Jika masih bisa ke bawah
                if (position.get("Row") < map.size() - 1){
                    Cell tempCell = (map.get(position.get("Row") + 1)).get(position.get("Col"));
                    if (tempCell.isWalkable()){
                        Land tempLand = (Land) tempCell;
                        if (tempLand.isOccupied()){
                            //cout << "BERGERAK KE " << position.first + 1 << " " << position.second << endl;
                            landPos.setObjectHere(null);
                            landPos = tempLand;
                            landPos.setObjectHere(this);
                            position.replace("Row", position.get("Row") - 1);
                        }
                    }
                }
                break;
            //Kiri
            case LEFT:
                //Jika masih bisa ke kiri
                if (position.get("Col") > 0){
                    Cell tempCell = (map.get(position.get("Row"))).get(position.get("Col") - 1);
                    if (tempCell.isWalkable()){
                        Land tempLand = (Land) tempCell;
                        if (!tempLand.isOccupied()){
                            //cout << "BERGERAK KE " << position.first << " " << position.second - 1 << endl;
                            landPos.setObjectHere(null);
                            landPos = tempLand;
                            landPos.setObjectHere(this);
                            position.replace("Col", position.get("Col") - 1);
                        }
                    }
                }
                break;
            //Kanan
            case RIGHT:
                //Jika masih bisa ke kanan
                if (position.get("Col") < map.get(position.get("Row")).size() - 1){
                    Cell tempCell = (map.get(position.get("Row"))).get(position.get("Col") + 1);
                    if (tempCell.isWalkable()){
                        Land tempLand = (Land) tempCell;
                        if (!tempLand.isOccupied()){
                            //cout << "BERGERAK KE " << position.first << " " << position.second + 1 << endl;
                            landPos.setObjectHere(null);
                            landPos = tempLand;
                            landPos.setObjectHere(this);
                            position.replace("Col", position.get("Col") + 1);
                        }
                    }
                }
                break;
        }
    }
}
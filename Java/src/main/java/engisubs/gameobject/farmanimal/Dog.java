package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;

public class Dog extends FarmAnimal implements MeatProducing{
    /**
     * Constructor dari Dog
     * @param  _position Posisi dari Dog
     * @param  _name     Nama dari Dog
     * @param  _landPos  Posisi Land dimana Dog berada
     * @return           Instance dari Dog
     */
    public Dog(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initGameObject(GameObjectType.DOG, 'D');
        initializeFarmAnimal(_position, _name, _landPos);
    }
    /**
     * Method untuk menghasilkan daging
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMeat(Player<?> _p){
        _p.addInventory(new DogMeat(50, name));
    }
    /**
     * Method untuk berbicara
     */
    public void talk(){
        System.out.println(name + ": Woof Rawr XD");
    }
    /**
     * Method untuk melakukan interaksi kepada Dog sebagai perwujudan fungsi abstrak pada GameObject
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
        System.out.println("You cannot do anything with a Dog, or can you? *wink*");
    }
}
package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.egg.*;
import engisubs.gameobject.product.farmproduct.milk.*;

public class Platypus extends FarmAnimal implements MeatProducing, EggProducing, MilkProducing{
    /**
     * Constructor dari Platypus
     * @param  _position Posisi dari Platypus
     * @param  _name     Nama dari Platypus
     * @param  _landPos  Posisi Land dimana Platypus berada
     * @return           Instance dari Platypus
     */    
    public Platypus(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initGameObject(GameObjectType.PLATYPUS, 'Y');
        initializeFarmAnimal(_position, _name, _landPos);
    }
    /**
     * Method untuk menghasilkan daging
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMeat(Player<?> _p){
        _p.addInventory(new PlatypusMeat(70, name));
    }
    /**
     * Method untuk menghasilkan telur
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceEgg(Player<?> _p){
        _p.addInventory(new PlatypusEgg(10, name));
    }
    /**
     * Method untuk menghasilkan susu
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMilk(Player<?> _p){
        _p.addInventory(new PlatypusMilk(15, name));
    }
    /**
     * Method untuk berbicara
     */
    public void talk(){
        System.out.println(name + ": It is I, " + name + ", Destroyer of Worlds!");
    }
    /**
     * Method untuk melakukan interaksi dimana Platypus akan menghasilkan telur dan susu
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
        if (!getIsProductProduced()){
            produceEgg(_p);
            produceMilk(_p);
            isProductProduced = true;
        }
    }
    /*
    public void eat() {
        System.out.println("PLATYPUS MAKAN");
        super.eat();
        setIsProductProduced(false);
    }
    */
}
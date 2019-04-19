package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.egg.*;
import engisubs.gameobject.product.farmproduct.milk.*;

public class Platypus extends FarmAnimal implements MeatProducing, EggProducing, MilkProducing{
    public Platypus(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initGameObject(GameObjectType.PLATYPUS, 'Y');
        initializeFarmAnimal(_position, _name, _landPos);
    }

    public void produceMeat(Player _p){
        _p.addInventory(new PlatypusMeat(70, name));
    }

    public void produceEgg(Player _p){
        _p.addInventory(new PlatypusEgg(10, name));
    }

    public void produceMilk(Player _p){
        _p.addInventory(new PlatypusMilk(15, name));
    }

    public void talk(){
        System.out.println(name + ": It is I, " + name + ", Destroyer of Worlds!");
    }

    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceEgg(_p);
            produceMeat(_p);
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
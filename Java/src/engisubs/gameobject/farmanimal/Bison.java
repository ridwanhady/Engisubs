package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.Land;
import engisubs.gameobject.product.farmproduct.meat.BisonMeat;
import engisubs.gameobject.product.farmproduct.milk.BisonMilk;

public class Bison extends FarmAnimal implements MeatProducing, MilkProducing{
    public Bison(Map <String, Integer> _position, String _name, Land _landPos){
        initializeFarmAnimal(_position, _name, _landPos);
        initGameObject(GameObjectType.BISON, 'B');
    }

    public void produceMeat(Player _p){
        _p.addInventory(new BisonMeat(100, name));
    }

    public void produceMilk(Player _p){
        _p.addInventory(new BisonMilk(15, name));
    }

    public void talk(){
        System.out.println("Mwooahahaha!");
    }

    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceMilk(_p);
        }
    }

}
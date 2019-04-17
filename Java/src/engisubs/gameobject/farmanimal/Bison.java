package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.Land;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.milk.*;

public class Bison extends FarmAnimal implements MeatProducing, MilkProducing{
    public Bison(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initializeFarmAnimal(_position, _name, _landPos);
        initGameObject(GameObjectType.BISON, 'B');
    }

    public void produceMeat(Player _p){
        _p.addInventory(new BisonMeat(100, name));
    }

    public void produceMilk(Player _p){
        _p.addInventory(new BisonMilk(20, name));
    }

    public void talk(){
        System.out.println(name + ": Mwooahahaha!");
    }

    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceMilk(_p);
            isProductProduced = true;
        }
    }

}
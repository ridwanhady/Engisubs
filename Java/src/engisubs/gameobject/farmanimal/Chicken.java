package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.egg.*;

public class Chicken extends FarmAnimal implements MeatProducing, EggProducing{
    public Chicken(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.CHICKEN, 'C');
        initializeFarmAnimal(_position, _name, _landPos);
    }

    public void produceMeat(Player _p){
        _p.addInventory(new ChickenMeat(30, name));
    }

    public void produceEgg(Player _p){
        _p.addInventory(new ChickenEgg(5, name));
    }

    public void talk(){
        System.out.println(name + ": Petak Petok!");
    }

    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceEgg(_p);
            isProductProduced = true;
        }
    }
}
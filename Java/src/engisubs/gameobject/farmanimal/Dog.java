package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;

public class Dog extends FarmAnimal implements MeatProducing{
    public Dog(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.DOG, 'D');
        initializeFarmAnimal(_position, _name, _landPos);
    }

    public void produceMeat(Player _p){
        _p.addInventory(new DogMeat(50, name));
    }

    public void talk(){
        System.out.println(name + ": Woof Rawr XD");
    }

    public void interact(Player _p){
        System.out.println("You cannot do anything with a Dog, or can you? *wink*");
    }
}
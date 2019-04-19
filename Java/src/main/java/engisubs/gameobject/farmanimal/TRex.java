package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;

public class TRex extends FarmAnimal implements MeatProducing{
    public TRex(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.TREX, 'X');
        initializeFarmAnimal(_position, _name, _landPos);
        super.killable = true;
    }

    public void produceMeat(Player _p){
        _p.addInventory(new TRexMeat(200, name));
    }

    public void talk(){
        System.out.println(name + ": Reeeeeeee!");
    }

    public void interact(Player _p){
        System.out.println("You cannot do anything with the great TRex, or can you? *wink*");
    }
}
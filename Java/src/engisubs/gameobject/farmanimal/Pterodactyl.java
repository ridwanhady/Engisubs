package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.egg.*;

public class Pterodactyl extends FarmAnimal implements EggProducing{
    public Pterodactyl(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.PTERODACTYL, 'L');
    }

    public void produceEgg(Player _p){
        _p.addInventory(new PterodactylEgg(15, name));
    }

    public void talk(){
        System.out.println(name + ": Nyehehehehe!");
    }

    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceEgg(_p);
            isProductProduced = true;
        }
    }
}
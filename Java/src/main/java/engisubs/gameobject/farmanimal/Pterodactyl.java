package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.egg.*;

public class Pterodactyl extends FarmAnimal implements EggProducing{
    /**
     * Constructor dari Pterodactyl
     * @param  _position Posisi dari Pterodactyl
     * @param  _name     Nama dari Pterodactyl
     * @param  _landPos  Posisi Land dimana Pterodactyl berada
     * @return           Instance dari Pterodactyl
     */    
    public Pterodactyl(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.PTERODACTYL, 'L');
        initializeFarmAnimal(_position, _name, _landPos);
    }
    /**
     * Method untuk menghasilkan telur
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceEgg(Player<?> _p){
        _p.addInventory(new PterodactylEgg(15, name));
    }
    /**
     * Method untuk berbicara
     */
    public void talk(){
        System.out.println(name + ": Nyehehehehe!");
    }
    /**
     * Method untuk melakukan interaksi dimana Pterodactyl akan menghasilkan telur
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
        if (!getIsProductProduced()){
            produceEgg(_p);
            isProductProduced = true;
        }
    }
}
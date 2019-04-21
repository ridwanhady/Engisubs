package engisubs.gameobject.farmanimal;

import java.util.*;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;

public class TRex extends FarmAnimal implements MeatProducing{
    /**
     * Constructor dari TRex
     * @param  _position Posisi dari TRex
     * @param  _name     Nama dari TRex
     * @param  _landPos  Posisi Land dimana TRex berada
     * @return           Instance dari TRex
     */   
    public TRex(Map <String, Integer> _position, String _name, Land _landPos){
        initGameObject(GameObjectType.TREX, 'X');
        initializeFarmAnimal(_position, _name, _landPos);
        super.killable = true;
    }
    /**
     * Method untuk menghasilkan daging
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMeat(Player _p){
        _p.addInventory(new TRexMeat(200, name));
    }
    /**
     * Method untuk berbicara
     */
    public String talk(){
        System.out.println(name + ": Reeeeeeee!");
        return name + ": Reeeeeeee!";
    }
    /**
     * Method untuk melakukan interaksi kepada TRex sebagai perwujudan fungsi abstrak pada GameObject
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player _p){
        System.out.println("You cannot do anything with the great TRex, or can you? *wink*");
    }
}
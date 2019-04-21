package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.Land;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.milk.*;

public class Bison extends FarmAnimal implements MeatProducing, MilkProducing{
    /**
     * Constructor dari Bison
     * @param  _position Posisi dari Bison
     * @param  _name     Nama dari Bison
     * @param  _landPos  Posisi land dimana bison berada
     * @return           Instance Bison
     */
    public Bison(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initializeFarmAnimal(_position, _name, _landPos);
        initGameObject(GameObjectType.BISON, 'B');
    }
    /**
     * Method untuk menghasilkan daging
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMeat(Player _p){
        _p.addInventory(new BisonMeat(100, name));
    }
    /**
     * Method untuk menghasilkan susu
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMilk(Player _p){
        _p.addInventory(new BisonMilk(20, name));
    }
    /**
     * Method untuk berbicara
     */
    public void talk(){
        System.out.println(name + ": Mwooahahaha!");
    }
    /**
     * Method untuk melakukan interaksi dimana Bison akan menghasilkan susu
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player _p){
        if (!getIsProductProduced()){
            produceMilk(_p);
            isProductProduced = true;
        }
    }

}
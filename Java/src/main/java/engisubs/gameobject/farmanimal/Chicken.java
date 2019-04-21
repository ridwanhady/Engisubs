package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.egg.*;

public class Chicken extends FarmAnimal implements MeatProducing, EggProducing{
    /**
     * Constructor dari Chicken
     * @param  _position Posisi dari Chicken
     * @param  _name     Nama dari Chicken
     * @param  _landPos  Posisi Land dimana Chicken berada
     * @return           Instance dari Chicken
     */
    public Chicken(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initGameObject(GameObjectType.CHICKEN, 'C');
        initializeFarmAnimal(_position, _name, _landPos);
        setIsProductProduced(true);
    }
    /**
     * Method untuk menghasilkan daging
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceMeat(Player<?> _p){
        _p.addInventory(new ChickenMeat(30, name));
    }
    /**
     * Method untuk menghasilkan telur
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void produceEgg(Player<?> _p){
        _p.addInventory(new ChickenEgg(5, name));
    }
    /**
     * Method untuk berbicara
     */
    public String talk(){
        System.out.println(name + ": Petak Petok!");
        return name + ": Petak Petok!";
    }
    /**
     * Method untuk melakukan interaksi dimana Chicken akan menghasilkan telur
     * @param _p Reference dari player untuk melakukan penambahan inventory
     */
    public void interact(Player<?> _p){
        //System.out.println("Kamu Berinteraksi dengan Ayam!");
        if (!getIsProductProduced()){
            //System.out.println("Produk siap diproduksi!");
            produceEgg(_p);
            isProductProduced = true;
        } else {
            //System.out.println("Produk belum diproduksi!");
        }
    }


}
package engisubs.gameobject.farmanimal;

import java.util.*;
import engisubs.gameobject.*;
import engisubs.gameobject.cell.land.*;
import engisubs.gameobject.product.farmproduct.meat.*;
import engisubs.gameobject.product.farmproduct.egg.*;

public class Chicken extends FarmAnimal implements MeatProducing, EggProducing{
    public Chicken(Map <String, Integer> _position, String _name, Land _landPos){
        super.killable = true;
        initGameObject(GameObjectType.CHICKEN, 'C');
        initializeFarmAnimal(_position, _name, _landPos);
        setIsProductProduced(true);
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
        System.out.println("Kamu Berinteraksi dengan Ayam!");
        if (!getIsProductProduced()){
            System.out.println("Produk siap diproduksi!");
            produceEgg(_p);
            isProductProduced = true;
        } else {
            System.out.println("Produk belum diproduksi!");
        }
    }


}
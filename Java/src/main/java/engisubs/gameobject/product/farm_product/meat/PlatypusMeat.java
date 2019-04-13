package main.java.engisubs.gameobject.product.farm_product.meat;

public class PlatypusMeat extends Meat{
    public PlatypusMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PLATYPUS_MEAT, "Daging Segar Platypus");
    }
}
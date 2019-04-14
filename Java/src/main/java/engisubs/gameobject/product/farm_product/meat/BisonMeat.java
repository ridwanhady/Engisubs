package main.java.engisubs.gameobject.product.farm_product.meat;

public class BisonMeat extends Meat{
    public BisonMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.BISON_MEAT, "Daging Segar BISON");
    }
}
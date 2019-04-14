package main.java.engisubs.gameobject.product.farm_product.meat;

public class ChickenMeat extends Meat{
    public ChickenMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.CHICKEN_MEAT, "Daging Segar Ayamosaurus Rex");
    }
}
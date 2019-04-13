package main.java.engisubs.gameobject.product.farm_product.egg;

public class ChickenEgg extends Egg{
    public ChickenEgg(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.CHICKEN_EGG, "Telur Ayam Pasaran");
    }
}
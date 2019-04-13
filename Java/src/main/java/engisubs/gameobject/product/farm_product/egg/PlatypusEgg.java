package main.java.engisubs.gameobject.product.farm_product.egg;

public class PlatypusEgg extends Egg{
    public PlatypusEgg(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PTERODACTYL_EGG, "Telur \"Mamalia\" Platypus");
    }
}
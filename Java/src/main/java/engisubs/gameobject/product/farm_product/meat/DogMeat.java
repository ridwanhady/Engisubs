package main.java.engisubs.gameobject.product.farm_product.meat;

public class DogMeat extends Meat{
    public DogMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.DOG_MEAT, "Daging Segar Anjing");
    }
}
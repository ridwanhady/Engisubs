package main.java.engisubs.gameobject.product.farm_product.milk;

public class PlatypusMilk extends Milk{
    public PlatypusMilk(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PLATYPUS_MILK, "Susu Murni Platypus");
    }
}
package main.java.engisubs.gameobject.product.farm_product.meat;

public class TRexMeat extends Meat{
    public TRexMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.TREX_MEAT, "Daging Segar TyranoSaurus-Rex");
    }
}
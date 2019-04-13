package main.java.engisubs.gameobject.product.farm_product.milk;

public class BisonMilk extends Milk{
    public BisonMilk(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.BISON_MILK, "Susu Murni Bison");
    }
}
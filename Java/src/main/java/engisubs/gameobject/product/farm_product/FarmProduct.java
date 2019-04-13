package main.java.engisubs.gameobject.product.farm_product;

import main.java.engisubs.gameobject.product.Product;

public class FarmProduct extends Product{
    protected String producer;

    public FarmProduct(){}

    public void initializeFarmProduct(String _producer){
        this.producer = _producer;
    }

    public String getProducer(){
        return this.producer;
    }

    public static FarmProductType getFarmProductType(GameObjectType objectType){
        if (objectType == GameObjectType.CHICKEN_EGG || objectType == GameObjectType.PLATYPUS_EGG || objectType == GameObjectType.PTERODACTYL_EGG) {
            return FarmProductType.EGG;
        } else if (objectType == GameObjectType.BISON_MEAT || objectType == GameObjectType.CHICKEN_MEAT || objectType == GameObjectType.DOG_MEAT || objectType == GameObjectType.PLATYPUS_MEAT || objectType == GameObjectType.TREX_MEAT){
            return FarmProductType.MEAT;
        } else if (objectType == GameObjectType.BISON_MILK || objectType == GameObjectType.PLATYPUS_MILK) {
            return FarmProductType.MILK;
        } else {
            return FarmProductType.NOT_FOUND;
        }
    }
}
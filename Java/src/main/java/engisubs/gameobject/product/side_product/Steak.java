package main.java.engisubs.gameobject.product.side_product;

import java.util.LinkedList;

public class Steak extends SideProduct{
    private static LinkedList<FarmProductType> resep;

    public Steak(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.STEAK, "Medium Rare Espanolia Steak~~");
    }

    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    public static FarmProductType getResepwithIdx(int index){
        return getResep().get(index);
    }

    public static void InitResep(){
        resep.add(FarmProductType.MEAT);
        resep.add(FarmProductType.EGG);
    }
}
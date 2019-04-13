package main.java.engisubs.gameobject.product.side_product;

import java.util.LinkedList;

public class Mayonaise extends SideProduct{
    private static LinkedList<FarmProductType> resep;

    public Mayonaise(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.MAYONAISE, "Nice Sauce for a Nice Food~~");
    }

    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    public static FarmProductType getResepwithIdx(int index){
        return getResep().get(index);
    }

    public static void InitResep(){
        resep.add(FarmProductType.EGG);
        resep.add(FarmProductType.MILK);
    }
}
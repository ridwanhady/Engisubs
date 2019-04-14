package main.java.engisubs.gameobject.product.side_product;

import java.util.LinkedList;

public class Cheese extends SideProduct{
    private static LinkedList<FarmProductType> resep;

    public Cheese(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.CHEESE, "Mozarella Cheese Italiano~~");
    }

    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    public static FarmProductType getResepwithIdx(int index){
        return getResep().get(index);
    }

    public static void InitResep(){
        resep.add(FarmProductType.MILK);
        resep.add(FarmProductType.EGG);
    }
}
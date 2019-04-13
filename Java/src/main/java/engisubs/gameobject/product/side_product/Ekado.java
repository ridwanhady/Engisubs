package main.java.engisubs.gameobject.product.side_product;

import java.util.LinkedList;

public class Ekado extends SideProduct{
    private static LinkedList<FarmProductType> resep;

    public Ekado(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.EKADO, "Tiongkok's Special Ekado~~");
    }

    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    public static FarmProductType getResepwithIdx(int index){
        return getResep().get(index);
    }

    public static void InitResep(){
        resep.add(FarmProductType.EGG);
        resep.add(FarmProductType.MEAT);
    }
}
package main.java.engisubs.gameobject.product.sideproduct;

import java.util.LinkedList;

/**
 * Ekado adalah salah satu kelas dalam bagian SideProduct.
 * Ekado dapat dibuat menggunakan Interact Mixer.
 * Bahan Bahan Pembuat Ekado adalah :
 * EGG & MEAT
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class Ekado extends SideProduct{
    /**
     * Atribut Resep menyimpan daftar bahan yang digunakan untuk membuat Ekado di Mixer.
     */
    private static LinkedList<FarmProductType> resep;

    /**
     * Constructor dengan Parameter
     * @param _price
     */
    public Ekado(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.EKADO, "Tiongkok's Special Ekado~~");
    }

    /**
     * Getter untuk resep Ekado
     * @return resep
     */
    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    /**
     * Getter untuk resep Ekado dengan Index tertentu
     * Index yang bisa dilayani saat ini antara 0-1, karena resep ekado hanya terdiri dari 2 elemen
     * @param index
     * @return resep[index] , or null if not found
     */
    public static FarmProductType getResepwithIdx(int index){
        try{
            return getResep().get(index);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
        
    }

    /**
     * Inisialisasi Resep dari Ekado, mengisi Atribut resep dengan 2 bahan Utama yaitu
     * EGG & MEAT
     */
    public static void InitResep(){
        resep.add(FarmProductType.EGG);
        resep.add(FarmProductType.MEAT);
    }
}
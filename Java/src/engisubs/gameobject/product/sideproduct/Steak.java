package engisubs.gameobject.product.sideproduct;

import java.util.LinkedList;
/**
 * Steak adalah salah satu kelas dalam bagian SideProduct.
 * Steak dapat dibuat menggunakan Interact Mixer.
 * Bahan Bahan Pembuat Steak adalah :
 * MEAT & EGG
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class Steak extends SideProduct{
    /**
     * Atribut Resep menyimpan daftar bahan yang digunakan untuk membuat Steak di Mixer.
     */
    private static LinkedList<FarmProductType> resep = new LinkedList<>();

    /**
     * Constructor dengan Parameter
     * @param _price
     */
    public Steak(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.STEAK, "Medium Rare Espanolia Steak~~");
    }

    /**
     * Getter untuk resep Steak
     * @return resep
     */
    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    /**
     * Getter untuk resep Steak dengan Index tertentu
     * Index yang bisa dilayani saat ini antara 0-1, karena resep Steak hanya terdiri dari 2 elemen
     * @param index
     * @return resep[index] , or null if not found
     */
    public static FarmProductType getResepwithIdx(int index){
        return resep.get(index);
    }

    /**
     * Inisialisasi Resep dari Steak, mengisi Atribut resep dengan 2 bahan Utama yaitu
     * MEAT & EGG
     */
    public static void InitResep(){
        resep.add(FarmProductType.MEAT);
        resep.add(FarmProductType.EGG);
    }
}
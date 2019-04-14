package engisubs.gameobject.product.side_product;

import java.util.LinkedList;

/**
 * Cheese adalah salah satu kelas dalam bagian SideProduct.
 * Cheese dapat dibuat menggunakan Interact Mixer. 
 * Bahan Bahan untuk membuat Cheese adalah:
 * MILK & EGG
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class Cheese extends SideProduct{
    /**
     * Atribut Resep menyimpan daftar bahan yang digunakan untuk membuat Cheese di Mixer
     */
    private static LinkedList<FarmProductType> resep;

    /**
     * Constructor dengan parameter
     * @param _price
     */
    public Cheese(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.CHEESE, "Mozarella Cheese Italiano~~");
    }

    /**
     * Getter untuk resep dari Cheese
     * @return resep
     */
    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    /**
     * Getter untuk resep Cheese dengan Index tertentu
     * Index yang bisa dilayani saat ini antara 0/1, karena resep Cheese hanya terdiri dari 2 bahan
     * @param index
     * @return resep[index], or null if not found
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
     * Inisialisasi Resep dari Cheese, mengisi Atribut resep dengan 2 bahan utama pembuat Cheese yaitu 
     * MILK & EGG
     */
    public static void InitResep(){
        resep.add(FarmProductType.MILK);
        resep.add(FarmProductType.EGG);
    }
}
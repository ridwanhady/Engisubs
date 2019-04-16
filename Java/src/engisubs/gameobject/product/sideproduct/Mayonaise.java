package engisubs.gameobject.product.sideproduct;

import java.util.LinkedList;
/**
 * Mayonaise adalah salah satu kelas dalam bagian SideProduct.
 * Mayonaise dapat dibuat menggunakan Interact Mixer.
 * Bahan Bahan Pembuat Mayonaise adalah :
 * EGG & MILK
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class Mayonaise extends SideProduct{
    /**
     * Atribut Resep menyimpan daftar bahan yang digunakan untuk membuat Mayonaise di Mixer.
     */
    private static LinkedList<FarmProductType> resep;

    /**
     * Constructor dengan Parameter
     * @param _price
     */
    public Mayonaise(int _price){
        super.initializeProduct(_price, ProductType.SIDEPRODUCT, GameObjectType.MAYONAISE, "Nice Sauce for a Nice Food~~");
    }

    /**
     * Getter untuk resep Mayonaise
     * @return resep
     */
    public static LinkedList<FarmProductType> getResep(){
        return resep;
    }

    /**
     * Getter untuk resep Mayonaise dengan Index tertentu
     * Index yang bisa dilayani saat ini antara 0-1, karena resep Mayonaise hanya terdiri dari 2 elemen
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
     * Inisialisasi Resep dari Mayonaise, mengisi Atribut resep dengan 2 bahan Utama yaitu
     * EGG & MILK
     */
    public static void InitResep(){
        resep.add(FarmProductType.EGG);
        resep.add(FarmProductType.MILK);
    }
}
package main.java.engisubs.gameobject.product.farmproduct;

import engisubs.gameobject.product.Product;
/**
 * FarmProduct merupakan kelas yang digunakan sebagai Discrimator untuk product-product yang tergolong ke dalamnya
 * Kelas kelas tersebut memiliki beberapa jenis utama yaitu: MEAT, MILK dan EGG.
 * 
 * Selain sebagai Discrimator, FarmProduct juga memiliki beberapa Method yang akan membantu mempermudah 
 * kelas kelas di bawahnya.
 *  
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class FarmProduct extends Product{
    /**
     * Atribut producer akan memberikan informasi mengenai hewan 
     * mana yang memproduksi product tersebut.
     */ 
    protected String producer;

    /**
     * Constructor tanpa parameter
     */
    public FarmProduct(){}

    /**
     * Menginisialisasi Farm Product, yaitu mengeset Atribut Producer
     * @param _producer
     */
    public void initializeFarmProduct(String _producer){
        this.producer = _producer;
    }

    /**
     * Getter untuk atribut Producer
     * @return producer
     */
    public String getProducer(){
        return this.producer;
    }

    /**
     * Akan mengembalikan FarmProductType yang sesuai dengan GameObject yang dimiliki,
     * yaitu Abstraksi dari Product itu sendiri,
     * e.g. BISON_MEAT dan TREX_MEAT sama sama tergolong ke dalam MEAT
     * maka akan mengembalikan nilai berupa MEAT
     * @param objectType
     * @return FarmProductType
     */
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
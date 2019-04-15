package main.java.engisubs.gameobject.product.farmproduct.meat;

/**
 * PlatypusMeat adalah salah satu Golongan dari FarmProduct Meat,
 * Sesuai namanya, product ini dihasilkan oleh Platypus
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class PlatypusMeat extends Meat{
    /**
     * Constructor dengan parameter
     * @param _price
     * @param _producer
     */
    public PlatypusMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PLATYPUS_MEAT, "Daging Segar Platypus");
    }
}
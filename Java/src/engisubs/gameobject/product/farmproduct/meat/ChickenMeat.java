package engisubs.gameobject.product.farmproduct.meat;

/**
 * ChickenMeat adalah salah satu Golongan dari FarmProduct Meat,
 * Sesuai namanya, product ini dihasilkan oleh TRex
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class ChickenMeat extends Meat{
    /**
     * Constructor dengan parameter.
     * @param _price
     * @param _producer
     */
    public ChickenMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.CHICKEN_MEAT, "Daging Segar Ayamosaurus Rex");
    }
}
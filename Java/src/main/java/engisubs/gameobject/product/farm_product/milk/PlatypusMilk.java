package engisubs.gameobject.product.farm_product.milk;

/**
 * PlatypusMilk adalah salah satu Golongan dari FarmProduct Milk,
 * Sesuai namanya, product ini dihasilkan oleh Platypus
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class PlatypusMilk extends Milk{
    /**
     * Constructor dengan parameter
     * @param _price
     * @param _producer
     */
    public PlatypusMilk(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PLATYPUS_MILK, "Susu Murni Platypus");
    }
}
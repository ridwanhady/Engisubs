package engisubs.gameobject.product.farmproduct.egg;
/**
 * ChickenEgg adalah salah satu Golongan dari FarmProduct Egg,
 * Sesuai namanya, product ini dihasilkan oleh Chicken
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class ChickenEgg extends Egg{
    /**
     * Constructor dengan Parameter
     * @param _price
     * @param _producer
     */
    public ChickenEgg(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.CHICKEN_EGG, "Telur Ayam Pasaran");
    }
}
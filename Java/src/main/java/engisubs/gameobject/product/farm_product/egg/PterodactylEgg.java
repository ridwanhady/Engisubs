package engisubs.gameobject.product.farm_product.egg;
/**
 * PterodactylEgg adalah salah satu Golongan dari FarmProduct Egg,
 * Sesuai namanya, product ini dihasilkan oleh Pterodactyl
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class PterodactylEgg extends Egg{
    /**
     * Constructor dengan Parameter
     * @param _price
     * @param _producer
     */
    public PterodactylEgg(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.PTERODACTYL_EGG, "Telur Super Besar Pterodactyl");
    }
}
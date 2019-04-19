package engisubs.gameobject.product.farmproduct.meat;

/**
 * BisonMeat adalah salah satu Golongan dari FarmProduct Meat, Sesuai namanya,
 * product ini dihasilkan oleh Bison
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class BisonMeat extends Meat{
    /**
     * Constructor dengan parameter
     * @param _price
     * @param _producer
     */
    public BisonMeat(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.BISON_MEAT, "Daging Segar BISON");
    }
}
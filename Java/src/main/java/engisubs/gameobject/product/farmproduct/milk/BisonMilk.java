package main.java.engisubs.gameobject.product.farmproduct.milk;
/**
 * BisonMilk adalah salah satu Golongan dari FarmProduct Milk,
 * Sesuai namanya, product ini dihasilkan oleh Bison
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jaya
 */
public class BisonMilk extends Milk{
    /**
     * Constructor dengan parameter.
     * @param _price
     * @param _producer
     */
    public BisonMilk(int _price, String _producer){
        super.initializeFarmProduct(_producer);
        super.initializeProduct(_price, ProductType.FARMPRODUCT, GameObjectType.BISON_MILK, "Susu Murni Bison");
    }
}
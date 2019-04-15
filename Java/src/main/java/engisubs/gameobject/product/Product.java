package main.java.engisubs.gameobject.product;

import engisubs.gameobject.GameObject;

/**
 * Class Product berisi informasi terkait product
 * Informasi yang dimiliki adalah nama product
 * dan harga dari product.
 * Kelas ini merupakan turunan dari kelas GameObject
 * 
 * @author 007 - Mohammad Ridwan Hady Arifin
 * @author 025 - Ricky Yuliawan
 * @author 070 - Aidil Rezjki Suljztan Syawaludin	
 * @author 091 - Adyaksa Wisanggeni
 * @author 115 - Edward Alexander Jay
 */
public class Product extends GameObject{   
    /**
     * productType berisi informasi terkait Tipe Product.
     * Tipe tipe product tersebut ada di dalam enumerator ProductType
     */
    protected ProductType productType;
    
    /**
     * Nama dari produk
     */
    protected String productName;
    
    /**
     * Harga dari produk
     */
    protected int price;
    
    /**
     * Constructor dari Product, tidak memiliki Paramater.
     * Akan mengeset harga ke 0.
     */
    public Product(){
        super();
        this.price = 0;
    }

    /**
     * Getter dari productType
     * @return productType
     */
    public ProductType getProductType(){
        return this.productType;
    }

    /**
     * Getter dari price
     * @return price
     */
    public int getPrice(){
        return this.price;
    }

    /**
     * Getter dari productName
     * @return productName
     */
    public String getProductName(){
        return this.productName;
    }

    /**
     * Menginisialisasi Product sesuai dengan informasi 
     * yang diberikan pada parameter
     * @param _price
     * @param _productType
     * @param _gameObjectType
     * @param _productName
     */
    public void initializeProduct(int _price, ProductType _productType, GameObjectType _gameObjectType, String _productName){
        this.price = _price;
        this.productType = _productType;
        this.gameObjectType = _gameObjectType;
        this.productName = _productName;
    }
    /**
     * Enumerator Product Type
     */
    public enum ProductType {
        FARMPRODUCT,
        SIDEPRODUCT
    };
}
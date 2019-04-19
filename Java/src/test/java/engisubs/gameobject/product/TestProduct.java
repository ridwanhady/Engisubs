package engisubs.gameobject.product;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

import org.junit.Assert;

public class TestProduct {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Product test;

    @Before
    public void setUpStreams() {
        test = new Product();
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void initDefaultObjectTest(){
        Assert.assertEquals(0, test.getPrice());
        test.render();
        Assert.assertEquals("?", outContent.toString());
    }

    @Test
    public void initProductTest(){
        test.initializeProduct(80, ProductType.FARMPRODUCT, GameObjectType.BISON_MEAT, "Name");
        Assert.assertEquals(80, test.getPrice());
        Assert.assertEquals(ProductType.FARMPRODUCT, test.getProductType());
        Assert.assertEquals(GameObjectType.BISON_MEAT, test.getGameObjectType());
        Assert.assertEquals("Name", test.getProductName());
    }
}
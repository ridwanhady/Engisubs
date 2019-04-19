package engisubs.gameobject.product.sideproduct;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

public class TestSideProduct {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private SideProduct test;

    @Before
    public void setUpStreams() {
        test = new SideProduct();
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
        test.initializeProduct(80, ProductType.SIDEPRODUCT, GameObjectType.MAYONAISE, "Mayo");
        Assert.assertEquals(80, test.getPrice());
        Assert.assertEquals(ProductType.SIDEPRODUCT, test.getProductType());
        Assert.assertEquals(GameObjectType.MAYONAISE, test.getGameObjectType());
        Assert.assertEquals("Mayo", test.getProductName());
    }
}
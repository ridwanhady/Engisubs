package engisubs.gameobject.product.farmproduct;

import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.FarmProductType;
import engisubs.gameobject.GameObject.GameObjectType;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Assert;

public class TestFarmProduct {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private FarmProduct test;
    @Before
    public void instantiateObject(){
        test = new FarmProduct();
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void initObjectTest(){
        Assert.assertEquals(0, test.getPrice());
        test.render();
        Assert.assertEquals("?", outContent.toString());
    }

    @Test
    public void initProducerTest(){
        test.initializeFarmProduct("Name");
        Assert.assertEquals("Name", test.getProducer());
    }

    @Test
    public void testStaticGetFarmProductType(){
        Assert.assertEquals(FarmProductType.EGG, FarmProduct.getFarmProductType(GameObjectType.CHICKEN_EGG));
        Assert.assertEquals(FarmProductType.EGG, FarmProduct.getFarmProductType(GameObjectType.PLATYPUS_EGG));
        Assert.assertEquals(FarmProductType.EGG, FarmProduct.getFarmProductType(GameObjectType.PTERODACTYL_EGG));
        Assert.assertEquals(FarmProductType.MILK, FarmProduct.getFarmProductType(GameObjectType.BISON_MILK));
        Assert.assertEquals(FarmProductType.MILK, FarmProduct.getFarmProductType(GameObjectType.PLATYPUS_MILK));
        Assert.assertEquals(FarmProductType.MEAT, FarmProduct.getFarmProductType(GameObjectType.CHICKEN_MEAT));
        Assert.assertEquals(FarmProductType.MEAT, FarmProduct.getFarmProductType(GameObjectType.BISON_MEAT));
        Assert.assertEquals(FarmProductType.MEAT, FarmProduct.getFarmProductType(GameObjectType.TREX_MEAT));
        Assert.assertEquals(FarmProductType.MEAT, FarmProduct.getFarmProductType(GameObjectType.PLATYPUS_MEAT));
        Assert.assertEquals(FarmProductType.MEAT, FarmProduct.getFarmProductType(GameObjectType.DOG_MEAT));
    }
}
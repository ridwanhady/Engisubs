package engisubs.gameobject.product.farmproduct.egg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;
public class TestPlatypusEgg{
    private PlatypusEgg testPlatypusEgg;
    @Before
    public void initObject(){
        testPlatypusEgg = new PlatypusEgg(25, "Name");
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals("Name", testPlatypusEgg.getProducer());
        Assert.assertEquals(GameObjectType.PLATYPUS_EGG, testPlatypusEgg.getObjectType());
        Assert.assertEquals(ProductType.FARMPRODUCT, testPlatypusEgg.getProductType());
        Assert.assertEquals(25, testPlatypusEgg.getPrice());
    }

}
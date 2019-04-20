package engisubs.gameobject.product.farmproduct.meat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;
public class TestChickenMeat{
    private ChickenMeat test;
    @Before
    public void initObject(){
        test = new ChickenMeat(25, "Name");
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals("Name", test.getProducer());
        Assert.assertEquals(GameObjectType.CHICKEN_MEAT, test.getObjectType());
        Assert.assertEquals(ProductType.FARMPRODUCT, test.getProductType());
        Assert.assertEquals(25, test.getPrice());
    }

}
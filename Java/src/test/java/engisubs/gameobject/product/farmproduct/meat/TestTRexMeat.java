package engisubs.gameobject.product.farmproduct.meat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;
public class TestTRexMeat{
    private TRexMeat test;
    @Before
    public void initObject(){
        test = new TRexMeat(25, "Name");
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals("Name", test.getProducer());
        Assert.assertEquals(GameObjectType.TREX_MEAT, test.getObjectType());
        Assert.assertEquals(ProductType.FARMPRODUCT, test.getProductType());
        Assert.assertEquals(25, test.getPrice());
    }

}
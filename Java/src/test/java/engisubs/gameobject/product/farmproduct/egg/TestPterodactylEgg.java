package engisubs.gameobject.product.farmproduct.egg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;
public class TestPterodactylEgg{
    private PterodactylEgg test;
    @Before
    public void initObject(){
        test = new PterodactylEgg(25, "Name");
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals("Name", test.getProducer());
        Assert.assertEquals(GameObjectType.PTERODACTYL_EGG, test.getObjectType());
        Assert.assertEquals(ProductType.FARMPRODUCT, test.getProductType());
        Assert.assertEquals(25, test.getPrice());
    }

}
package engisubs.gameobject.product.sideproduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.FarmProductType;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

public class TestMayonaise{
    private Mayonaise test;

    @Before
    public void setUpObject() {
        test = new Mayonaise(80);
    }
    @Test
    public void instantiationTest(){
        Assert.assertEquals(80, test.getPrice());
        Assert.assertEquals(GameObjectType.MAYONAISE, test.getGameObjectType());
        Assert.assertEquals(ProductType.SIDEPRODUCT, test.getProductType());
        Assert.assertEquals("Mayo : The Nice Sauce for a Nice Food~~", test.getProductName());
    }
    @Test
    public void resepTest(){
        Mayonaise.InitResep();
        Assert.assertArrayEquals(new FarmProductType[]{FarmProductType.EGG, FarmProductType.MILK}, Mayonaise.getResep().toArray());
        Assert.assertEquals(null, Mayonaise.getResepwithIdx(3));
    }
}
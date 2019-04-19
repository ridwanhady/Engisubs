package engisubs.gameobject.product.sideproduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.FarmProductType;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

public class TestSteak{
    private Steak test;

    @Before
    public void setUpObject() {
        test = new Steak(100);
    }
    @Test
    public void instantiationTest(){
        Assert.assertEquals(100, test.getPrice());
        Assert.assertEquals(GameObjectType.STEAK, test.getGameObjectType());
        Assert.assertEquals(ProductType.SIDEPRODUCT, test.getProductType());
        Assert.assertEquals("Medium Rare Espanolia Steak~~", test.getProductName());
    }
    @Test
    public void resepTest(){
        Steak.InitResep();
        Assert.assertArrayEquals(new FarmProductType[]{FarmProductType.MEAT, FarmProductType.EGG}, Steak.getResep().toArray());
        Assert.assertEquals(null, Steak.getResepwithIdx(3));
    }
}
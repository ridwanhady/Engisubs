package engisubs.gameobject.product.sideproduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.FarmProductType;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

public class TestCheese{
    private Cheese test;

    @Before
    public void setUpObject() {
        test = new Cheese(100);
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals(100, test.getPrice());
        Assert.assertEquals(GameObjectType.CHEESE, test.getGameObjectType());
        Assert.assertEquals(ProductType.SIDEPRODUCT, test.getProductType());
        Assert.assertEquals("Mozarella Cheese Italiano~~", test.getProductName());
    }
    @Test
    public void resepTest(){
        Cheese.InitResep();
        Assert.assertArrayEquals(new FarmProductType[]{FarmProductType.MILK, FarmProductType.EGG}, Cheese.getResep().toArray());
        Assert.assertEquals(null, Cheese.getResepwithIdx(3));
    }
}
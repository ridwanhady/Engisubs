package engisubs.gameobject.product.sideproduct;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.FarmProductType;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.Product.ProductType;

public class TestEkado{
    private Ekado test;

    @Before
    public void setUpObject() {
        test = new Ekado(100);
    }
    @Test
    public void instantiationTest(){
        Assert.assertEquals(100, test.getPrice());
        Assert.assertEquals(GameObjectType.EKADO, test.getGameObjectType());
        Assert.assertEquals(ProductType.SIDEPRODUCT, test.getProductType());
        Assert.assertEquals("Tiongkok's Special Ekado~~", test.getProductName());
    }
    @Test
    public void resepTest(){
        Ekado.InitResep();
        Assert.assertArrayEquals(new FarmProductType[]{FarmProductType.EGG, FarmProductType.MEAT}, Ekado.getResep().toArray());
        Assert.assertEquals(null, Ekado.getResepwithIdx(3));
    }
}
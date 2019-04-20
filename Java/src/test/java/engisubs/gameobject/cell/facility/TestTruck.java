package engisubs.gameobject.cell.facility;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.Player;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.product.farmproduct.egg.ChickenEgg;
import engisubs.gameobject.product.farmproduct.meat.ChickenMeat;
import engisubs.gameobject.product.farmproduct.milk.BisonMilk;

public class TestTruck{
    private Truck test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<String, Integer> pos = new HashMap<>();
    private Player dummy;

    @Before
    public void initTruck(){
        pos.put("Row", 1);
        pos.put("Col", 1);
        test = new Truck(pos);
        dummy = new Player("Iwang", 8, 10, pos, null);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void initSuccess(){
        test.render();
        Assert.assertEquals("T", outContent.toString());
        Assert.assertEquals(GameObjectType.TRUCK, test.getGameObjectType());
        Assert.assertEquals(this.pos, test.getPosition());
    }

    @Test
    public void interactSuccess(){
        dummy.inventory.add(new ChickenEgg(20, "A"));
        dummy.inventory.add(new ChickenMeat(30, "A"));
        dummy.inventory.add(new BisonMilk(50, "C"));
        test.interact(dummy);
        Assert.assertNotEquals(10, dummy.getUang());
        Assert.assertTrue(dummy.getInventory().isEmpty());
        Assert.assertEquals(10, test.getNotUsableTurns());
    }
}

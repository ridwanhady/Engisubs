package engisubs.gameobject;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.DirectionType;

public class TestPlayer{
    private Player test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<String, Integer> pos = new HashMap<>();

    @Before
    public void initTruck(){
        pos.put("Row", 2);
        pos.put("Col", 2);
        test = new Player("Iwang", 10, 0, this.pos, null);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void instantiationSuccess(){
        Assert.assertEquals("Iwang", test.getName());
        Assert.assertEquals(10, test.getWater());
        Assert.assertNotEquals(100, test.getUang());
        Assert.assertTrue(test.getInventory().isEmpty());
    }

    //For interact method, the test is already included on its object
    //And so for Talk Method

}

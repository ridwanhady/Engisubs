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

public class TestWell{
    private Well test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<String, Integer> pos = new HashMap<>();
    private Player dummy;

    @Before
    public void initWell(){
        pos.put("Row", 1);
        pos.put("Col", 1);
        test = new Well(pos);
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
        Assert.assertEquals("W", outContent.toString());
        Assert.assertEquals(GameObjectType.WELL, test.getGameObjectType());
        Assert.assertEquals(this.pos, test.getPosition());
    }

    @Test
    public void interactSuccess(){
        Assert.assertEquals(8, dummy.getWater());
        test.interact(dummy);
        Assert.assertEquals(10, dummy.getWater());
        test.interact(dummy);
        Assert.assertEquals(10, dummy.getWater());
    }
}

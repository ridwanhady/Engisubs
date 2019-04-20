package engisubs.gameobject.cell.land;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject;
import engisubs.gameobject.cell.land.Land.LandType;

import org.junit.Assert;

public class TestCoop {
    private Coop test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<String, Integer> pos = new HashMap<>();

    @Before
    public void initObject(){
        pos.put("Row", 3);
        pos.put("Col", 3);
        test = new Coop(pos);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void instantiationTest(){
        Assert.assertTrue(test.isWalkable());
        Assert.assertEquals(pos, test.getPosition());
        Assert.assertEquals(LandType.COOP, test.getLandType());
    }

    @Test
    public void renderTest(){
        test.render();
        test.setObjectHere(null);
        test.render();
        test.ungrow();
        test.render();
        test.setObjectHere(new GameObject('T'));
        test.render();
        Assert.assertEquals("**oT", outContent.toString());
    }
}
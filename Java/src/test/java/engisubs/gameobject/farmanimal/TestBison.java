package engisubs.gameobject.farmanimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.Grassland;
public class TestBison{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Bison test;
    private Map<String, Integer> pos = new HashMap<>();

    @Before
    public void initTest() {
        pos.put("Row", 1);
        pos.put("Col", 2);
        Grassland landPos = new Grassland(pos);
        test = new Bison(pos, "Name", landPos);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void instantiationTest(){
        Assert.assertEquals("Name", test.getName());
        Assert.assertEquals(pos, test.getPosition());
        Assert.assertNotEquals(null, test.getLandPos());
        Assert.assertTrue(test.isKillable());
    }

    @Test
    public void itCanTalkSOMEHOW(){
        test.talk();
        Assert.assertEquals("Name: Mwooahahaha!", outContent.toString().trim());
    }

    @Test
    public void renderTest(){
        test.render();
        Assert.assertEquals("B", outContent.toString());
    }

    @Test
    public void itCanProduceMilk(){
        Player p = new Player("Iwang", 20, 20, this.pos, null);
        Assert.assertEquals(0,p.getInventory().size());
        test.interact(p);
        Assert.assertEquals(0,p.getInventory().size());
        test.eat();
        test.interact(p);
        Assert.assertEquals(1,p.getInventory().size());
    }

    @Test
    public void itCanProduceMeat(){
        Player p = new Player("Iwang", 20, 20, this.pos, null);
        Assert.assertEquals(0,p.getInventory().size());
        test.produceMeat(p);
        Assert.assertEquals(1,p.getInventory().size());
    }
}

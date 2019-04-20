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
public class TestPterodactyl{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Pterodactyl test;
    private Map<String, Integer> pos = new HashMap<>();
    private Grassland landPos;

    @Before
    public void initTest() {
        pos.put("Row", 1);
        pos.put("Col", 2);
        landPos = new Grassland(pos);
        test = new Pterodactyl(pos, "Name", landPos);
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
        Assert.assertNotNull(test.getLandPos());
        Assert.assertTrue(test.isKillable());
    }

    @Test
    public void itCanTalkSOMEHOW(){
        Assert.assertEquals("Name: Nyehehehehe!", outContent.toString());
    }

    @Test
    public void renderTest(){
        Assert.assertEquals("L", outContent.toString());
    }

    @Test
    public void itCanProduceEgg(){
        Player p = new Player("Iwang", 20, 20, this.pos, null);
        Assert.assertEquals(0,p.getInventory().size());
        test.interact(p);
        Assert.assertEquals(0,p.getInventory().size());
        test.eat();
        test.interact(p);
        Assert.assertEquals(1,p.getInventory().size());
    }
}

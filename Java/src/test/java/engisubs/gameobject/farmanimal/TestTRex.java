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
public class TestTRex{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private TRex test;
    private Map<String, Integer> pos = new HashMap<>();

    @Before
    public void setUpStreams() {
        pos.put("Row", 1);
        pos.put("Col", 2);
        test = new TRex(pos, "Name", null);
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
        Assert.assertEquals(null, test.getLandPos());
        Assert.assertTrue(test.isKillable());
    }

    @Test
    public void itCanTalkSOMEHOW(){
        test.talk();
        Assert.assertEquals("Name: Reeeeeeee!\n", outContent.toString());
    }

    @Test
    public void renderTest(){
        test.render();
        Assert.assertEquals("X", outContent.toString());
    }

    @Test
    public void interactTest(){
        test.interact(null);
        Assert.assertEquals("You cannot do anything with the great TRex, or can you? *wink*\n", outContent.toString());
    }

    @Test
    public void itCanProduceMeat(){
        Player p = new Player("Iwang", 20, 20, this.pos, null);
        Assert.assertEquals(0,p.getInventory().size());
        test.produceMeat(p);
        Assert.assertEquals(1,p.getInventory().size());
    }
}

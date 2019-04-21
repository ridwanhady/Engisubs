package engisubs.gameobject.cell.facility;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import engisubs.gameobject.GameObject.GameObjectType;

public class TestMixer{
    private Mixer test;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Map<String, Integer> pos = new HashMap<>();
    //private Player dummy;

    @Before
    public void initMixer(){
        pos.put("Row", 1);
        pos.put("Col", 1);
        test = new Mixer(pos);
        //dummy = new Player("Iwang", 8, 10, pos, null);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void initSuccess(){
        test.render();
        Assert.assertEquals("M", outContent.toString());
        Assert.assertEquals(GameObjectType.MIXER, test.getGameObjectType());
        Assert.assertEquals(this.pos, test.getPosition());
    }

    /*
    @Test
    public void interactSuccess(){
    }
    */
}

package engisubs.gameobject;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import engisubs.gameobject.GameObject;
import engisubs.gameobject.GameObject.GameObjectType;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
public class TestGameObject{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private DummyDerrived test;

    @Before
    public void setUpStreams() {
        test = new DummyDerrived();
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanStreams() {
        System.setOut(null);
    }

    @Test
    public void constructorWithoutParam(){
        GameObject cwp = new GameObject();
        cwp.render();
        Assert.assertEquals("?", outContent.toString());
    }
    @Test
    public void initializationTest(){
        Assert.assertEquals(GameObjectType.PLAYER, test.getGameObjectType());
    }

    @Test
    public void interactMethodTest(){
        test.interact(null);
        Assert.assertNotEquals("Must Be Override", outContent.toString().trim());
        Assert.assertEquals("Im just a dummy", outContent.toString().trim());
    }
    @Test
    public void renderMethodTest(){
        test.render();
        Assert.assertEquals("D", outContent.toString());
    }

    @Test
    public void initGameObjectMethodTest(){
        test.initGameObject(GameObjectType.BISON, 'B');
        Assert.assertNotEquals(GameObjectType.PLAYER, test.getGameObjectType());
        Assert.assertEquals(GameObjectType.BISON, test.getGameObjectType());
        test.render();
        Assert.assertNotEquals("D", outContent.toString());
        Assert.assertEquals("B", outContent.toString());
    }

}

class DummyDerrived extends GameObject{
    public DummyDerrived(){
        super('D');
        gameObjectType = GameObjectType.PLAYER;
    }

    @Override
    public void interact(Player _p){
        System.out.println("Im just a dummy");
    }
}
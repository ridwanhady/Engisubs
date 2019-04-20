package engisubs.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import engisubs.gameobject.GameObject.GameObjectType;

class CellPanel extends JLayeredPane{
    static private String pathUngrowed = "engisubs/ui/ASSETS/tilesets/grassland-ungrown.png";
    static private String pathCock = "engisubs/ui/ASSETS/character/cock.gif";

    private boolean isGrown = false;
    private JLabel cellGround = null;
    private JLabel charSprite = null;
    private GameObjectType objectHere = GameObjectType.CHICKEN;
    
    public CellPanel(boolean _isGrown){
        super();
        setLayout(null);
        setPreferredSize(new Dimension(80, 80));
        setBackground(Color.blue);
        isGrown = _isGrown;
        reinitGroundSprite();
        reinitCharSprite();
    }

    public void reinitGroundSprite(){
        if (cellGround != null){
            remove(cellGround);
        }

        if (!isGrown){
            cellGround = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathUngrowed)));
        }
        //cellGround.setLocation(0, 0);
        cellGround.setBounds(0, 0, 80, 80);
        setLayer(cellGround, 0);
        add(cellGround);
    }

    public void reinitCharSprite(){
        if (charSprite != null){
            remove(charSprite);
        }
        if (objectHere != GameObjectType.LAND){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathCock)));
        }
        //charSprite.setLocation(0, 0);
        charSprite.setBounds(0, 0, 80, 80);
        setLayer(charSprite, 1);
        add(charSprite);
    }
}
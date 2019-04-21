package engisubs.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import engisubs.gameobject.GameObject.GameObjectType;

class CellPanel extends JLayeredPane{
    static private String pathUngrown = "engisubs/ui/ASSETS/tilesets/grassland-ungrown.png";
    static private String pathGrown = "engisubs/ui/ASSETS/tilesets/grassland-grown.jpg";
    static private String pathCock = "engisubs/ui/ASSETS/Chicken/chickenn_2.gif";
    static private String pathBison = "engisubs/ui/ASSETS/Bison/bison_2.gif";
    static private String pathDog = "engisubs/ui/ASSETS/Dog/doggg_0.gif";
    static private String pathPlaty = "engisubs/ui/ASSETS/Platypus/platypus.gif";
    static private String pathPtero = "engisubs/ui/ASSETS/Pterodactyl/ptero_0.gif";
    static private String pathTRex = "engisubs/ui/ASSETS/TRex/trex_0.gif";
    static private String pathPlayer = "engisubs/ui/ASSETS/Player/playerrrr_0.gif";
    static private String pathWell = "engisubs/ui/ASSETS/tilesets/well.png";
    static private String pathTruck = "engisubs/ui/ASSETS/tilesets/truck.png";
    static private String pathMixer = "engisubs/ui/ASSETS/tilesets/mixer.png";

    private boolean isGrown = false;
    private JLabel cellGround = null;
    private JLabel charSprite = null;
    private GameObjectType objectHere = GameObjectType.PLAYER;
    
    public CellPanel(boolean _isGrown, GameObjectType _objectHere){
        
        super();
        invalidate();
        setLayout(null);
        setPreferredSize(new Dimension(80, 80));
        setBackground(Color.blue);
        isGrown = _isGrown;
        objectHere = _objectHere;
        reinitGroundSprite();
        reinitCharSprite();
        validate();
    }

    public void reinitGroundSprite(){
        if (cellGround != null){
            remove(cellGround);
            cellGround = null;
        }
        

        if (!isGrown){
            cellGround = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathUngrown)));
        }else {
            cellGround = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathGrown)));
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
        charSprite = null;
        if (objectHere == GameObjectType.CHICKEN){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathCock)));
        }else if (objectHere == GameObjectType.BISON){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathBison)));
        }else if (objectHere == GameObjectType.DOG){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathDog)));
        }else if (objectHere == GameObjectType.PLATYPUS){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPlaty)));
        }else if (objectHere == GameObjectType.PTERODACTYL){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPtero)));
        }else if (objectHere == GameObjectType.TREX){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathTRex)));
        }else if (objectHere == GameObjectType.PLAYER){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPlayer)));
        }else if (objectHere == GameObjectType.WELL){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathWell)));
        }else if (objectHere == GameObjectType.TRUCK){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathTruck)));
        }else if (objectHere == GameObjectType.MIXER){
            charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathMixer)));
        }else {
            return;
        }
        //charSprite.setLocation(0, 0);
        charSprite.setBounds(0, 0, 80, 80);
        setLayer(charSprite, 1);
        add(charSprite);
    }
}
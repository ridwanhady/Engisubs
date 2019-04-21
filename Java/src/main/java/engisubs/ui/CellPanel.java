package engisubs.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;

import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.GameObject.DirectionType;
import engisubs.gameobject.GameObject;
import engisubs.gameobject.Player;

class CellPanel extends JLayeredPane{
    static private String pathUngrown = "engisubs/ui/ASSETS/tilesets/grassland-ungrown.png";
    static private String pathGrown = "engisubs/ui/ASSETS/tilesets/grassland-grown.jpg";
    static private String pathCock = "engisubs/ui/ASSETS/Chicken/chickenn_2.gif";
    static private String pathBison = "engisubs/ui/ASSETS/Bison/bison_2.gif";
    static private String pathDog = "engisubs/ui/ASSETS/Dog/doggg_0.gif";
    static private String pathPlaty = "engisubs/ui/ASSETS/Platypus/platypus.gif";
    static private String pathPtero = "engisubs/ui/ASSETS/Pterodactyl/ptero_0.gif";
    static private String pathTRex = "engisubs/ui/ASSETS/TRex/trex_0.gif";
    static private String pathPlayerUp = "engisubs/ui/ASSETS/Player/playerrrr_0.gif";
    static private String pathPlayerLeft = "engisubs/ui/ASSETS/Player/playerrrr_1.gif";
    static private String pathPlayerDown = "engisubs/ui/ASSETS/Player/playerrrr_2.gif";
    static private String pathPlayerRight = "engisubs/ui/ASSETS/Player/playerrrr_3.gif";
    static private String pathWell = "engisubs/ui/ASSETS/tilesets/well.png";
    static private String pathTruck = "engisubs/ui/ASSETS/tilesets/truck.png";
    static private String pathMixer = "engisubs/ui/ASSETS/tilesets/mixer.png";

    private boolean isGrown = false;
    private JLabel cellGround = null;
    private JLabel charSprite = null;
    private GameObject objectHere = null;
    private final int CELLSIZE;
    
    public CellPanel(boolean _isGrown, GameObject _objectHere, int cellSize){
        super();
        CELLSIZE = cellSize;
        setLayout(null);
        setPreferredSize(new Dimension(cellSize, cellSize));
        //setBackground(Color.blue);
        isGrown = _isGrown;
        objectHere = _objectHere;
        reinitGroundSprite();
        reinitCharSprite();
    }

    public void reinitGroundSprite(){
        if (cellGround != null){
            remove(cellGround);
            cellGround = null;
        }
        
        String path = "";
        if (!isGrown){
            path = pathUngrown;
            //cellGround = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathUngrown)));
        }else {
            path = pathGrown;
            //cellGround = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathGrown)));
        }
        cellGround = new JLabel();
        cellGround.setBounds(0, 0, CELLSIZE, CELLSIZE);
        addImage(cellGround, path);
        setLayer(cellGround, 0);
        add(cellGround);
    }

    public void reinitCharSprite(){
        System.out.println("CHARSPRITE");
        if (charSprite != null){
            remove(charSprite);
        }
        charSprite = null;
        String path = "";
        if (objectHere.getObjectType() == GameObjectType.CHICKEN){
            path = pathCock;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathCock)));
        }else if (objectHere.getObjectType() == GameObjectType.BISON){
            path = pathBison;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathBison)));
        }else if (objectHere.getObjectType() == GameObjectType.DOG){
            path = pathDog;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathDog)));
        }else if (objectHere.getObjectType() == GameObjectType.PLATYPUS){
            path = pathPlaty;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPlaty)));
        }else if (objectHere.getObjectType() == GameObjectType.PTERODACTYL){
            path = pathPtero;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPtero)));
        }else if (objectHere.getObjectType() == GameObjectType.TREX){
            path = pathTRex;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathTRex)));
        }else if (objectHere.getObjectType() == GameObjectType.PLAYER){
            Player playerNow = (Player) objectHere;
            if (playerNow.getDirection() == DirectionType.UP) {
                path = pathPlayerUp;
            } else if (playerNow.getDirection() == DirectionType.DOWN) {
                path = pathPlayerDown;
            } else if (playerNow.getDirection() == DirectionType.LEFT) {
                path = pathPlayerLeft;
            } else if (playerNow.getDirection() == DirectionType.RIGHT) {
                path = pathPlayerRight;
            } else {
                path = pathPlayerDown;
            }
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathPlayer)));
        }else if (objectHere.getObjectType() == GameObjectType.WELL){
            path = pathWell;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathWell)));
        }else if (objectHere.getObjectType() == GameObjectType.TRUCK){
            path = pathTruck;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathTruck)));
        }else if (objectHere.getObjectType() == GameObjectType.MIXER){
            path = pathMixer;
            //charSprite = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(pathMixer)));
        }else {
            return;
        }
        charSprite = new JLabel();
        charSprite.setBounds(0, 0, CELLSIZE, CELLSIZE);
        addImage(charSprite, path);
        setLayer(charSprite, 1);
        add(charSprite);
    }
    private void addImage(JLabel label, String path){
        URL url = getClass().getClassLoader().getResource(path);
        ImageIcon icon = new ImageIcon(url);
        icon.setImage(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
}
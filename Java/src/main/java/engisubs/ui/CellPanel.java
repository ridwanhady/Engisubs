package engisubs.ui;

import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import engisubs.gameobject.GameObject;
import engisubs.gameobject.GameObject.DirectionType;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.Player;
import engisubs.gameobject.cell.land.Land;
import engisubs.gameobject.farmanimal.FarmAnimal;

class CellPanel extends JLayeredPane{
    static private String pathGrasslandUngrown = "engisubs/ui/ASSETS/tilesets/grassland-ungrown.png";
    static private String pathGrasslandGrown = "engisubs/ui/ASSETS/tilesets/grassland-grown.jpg";
    static private String pathBarnUngrown = "engisubs/ui/ASSETS/tilesets/barn-ungrown.png";
    static private String pathBarnGrown = "engisubs/ui/ASSETS/tilesets/barn-grown.png";
    static private String pathCoopUngrown = "engisubs/ui/ASSETS/tilesets/coop-ungrown.png";
    static private String pathCoopGrown = "engisubs/ui/ASSETS/tilesets/coop-grown.png";
    static private String pathCock = "engisubs/ui/ASSETS/Chicken/chickenn_2.gif";
    static private String pathCockHungry = "engisubs/ui/ASSETS/Chicken/chickenn_2_hungry.gif";
    static private String pathBison = "engisubs/ui/ASSETS/Bison/bison_2.gif";
    static private String pathBisonHungry = "engisubs/ui/ASSETS/Bison/bison_2_hungry.gif";
    static private String pathDog = "engisubs/ui/ASSETS/Dog/doggg_0.gif";
    static private String pathDogHungry = "engisubs/ui/ASSETS/Dog/doggg_0_hungry.gif";
    static private String pathPlaty = "engisubs/ui/ASSETS/Platypus/platypus.gif";
    static private String pathPlatyHungry = "engisubs/ui/ASSETS/Platypus/platypus_hungry.gif";
    static private String pathPtero = "engisubs/ui/ASSETS/Pterodactyl/ptero_0.gif";
    static private String pathPteroHungry = "engisubs/ui/ASSETS/Pterodactyl/ptero_0_hungry.gif";
    static private String pathTRex = "engisubs/ui/ASSETS/TRex/trex_0.gif";
    static private String pathTRexHungry = "engisubs/ui/ASSETS/TRex/trex_0_hungry.gif";
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
    private Land landHere = null;
    private final int CELLSIZE;
    /**
     * Constructor CellPanel
     * @param  _isGrown  Menandakan apakah terdapat rumput di Cell atau tidak
     * @param  _cellHere Object Cell
     * @param  cellSize  Ukuran pixel dari Cell
     * @return           Instance dari CellPanel
     */
    public CellPanel(boolean _isGrown, GameObject _cellHere, int cellSize){
        super();
        CELLSIZE = cellSize;
        setLayout(null);
        setPreferredSize(new Dimension(cellSize, cellSize));
        //setBackground(Color.blue);
        isGrown = _isGrown;

        if(_cellHere.getGameObjectType() == GameObjectType.LAND){
            if( ((Land)_cellHere).isOccupied()){
                objectHere = ((Land)_cellHere).getObjectHere();
            } else objectHere = _cellHere;
            landHere = (Land)_cellHere;
            reinitGroundSprite();
        } else {
            objectHere = _cellHere;
        }
        
        reinitCharSprite();
    }
    /**
     * Membuat sprite Land
     */
    public void reinitGroundSprite(){
        if (cellGround != null){
            remove(cellGround);
            cellGround = null;
        }
        
        String path = "";
        if (!isGrown){
            if(landHere.getLandType() == Land.LandType.GRASSLAND){
                path = pathGrasslandUngrown;
            } else if(landHere.getLandType() == Land.LandType.BARN){
                path = pathBarnUngrown;
            } else if(landHere.getLandType() == Land.LandType.COOP){
                path = pathCoopUngrown;
            }
        }else {
            if(landHere.getLandType() == Land.LandType.GRASSLAND){
                path = pathGrasslandGrown;
            } else if(landHere.getLandType() == Land.LandType.BARN){
                path = pathBarnGrown;
            } else if(landHere.getLandType() == Land.LandType.COOP){
                path = pathCoopGrown;
            }
        }
        cellGround = new JLabel();
        cellGround.setBounds(0, 0, CELLSIZE, CELLSIZE);
        addImage(cellGround, path);
        setLayer(cellGround, 0);
        add(cellGround);
    }
    /**
     * Membuat sprite karakter
     */
    public void reinitCharSprite(){
        System.out.println("CHARSPRITE");
        if (charSprite != null){
            remove(charSprite);
        }
        charSprite = null;
        String path = "";
        System.out.println(objectHere.getObjectType());
        if (objectHere.getObjectType() == GameObjectType.CHICKEN){
            FarmAnimal CockNow = (FarmAnimal) objectHere;
            if (CockNow.getTimeUntilHungry() <= 0) {
                path = pathCockHungry;
            } else {
                path = pathCock;
            }
        }else if (objectHere.getObjectType() == GameObjectType.BISON){
            FarmAnimal BisonNow = (FarmAnimal) objectHere;
            if (BisonNow.getTimeUntilHungry() <= 0) {
                path = pathBisonHungry;
            } else {
                path = pathBison;
            }
            
        }else if (objectHere.getObjectType() == GameObjectType.DOG){
            FarmAnimal DogNow = (FarmAnimal) objectHere;
            if (DogNow.getTimeUntilHungry() <= 0) {
                path = pathDogHungry;
            } else {
                path = pathDog;
            }
            path = pathDog;
        }else if (objectHere.getObjectType() == GameObjectType.PLATYPUS){
            FarmAnimal PlatyNow = (FarmAnimal) objectHere;
            if (PlatyNow.getTimeUntilHungry() <= 0) {
                path = pathPlatyHungry;
            } else {
                path = pathPlaty;
            }
        }else if (objectHere.getObjectType() == GameObjectType.PTERODACTYL){

            FarmAnimal PteroNow = (FarmAnimal) objectHere;
            if (PteroNow.getTimeUntilHungry() <= 0) {
                path = pathPteroHungry;
            } else {
                path = pathPtero;
            }
        
        }else if (objectHere.getObjectType() == GameObjectType.TREX){
            FarmAnimal TRexNow = (FarmAnimal) objectHere;
            if (TRexNow.getTimeUntilHungry() <= 0) {
                path = pathTRexHungry;
            } else {
                path = pathTRex;
            }
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
        }else if (objectHere.getObjectType() == GameObjectType.WELL){
            path = pathWell;
        }else if (objectHere.getObjectType() == GameObjectType.TRUCK){
            path = pathTruck;
        }else if (objectHere.getObjectType() == GameObjectType.MIXER){
            path = pathMixer;
        }else {
            return;
        }
        charSprite = new JLabel();
        charSprite.setBounds(0, 0, CELLSIZE, CELLSIZE);
        addImage(charSprite, path);
        setLayer(charSprite, 1);
        add(charSprite);
    }

    /**
     * Menambahkan resizable image
     * @param label Tempat menaruh image yang dibuat
     * @param path  Lokasi file image
     */
    private void addImage(JLabel label, String path){
        URL url = getClass().getClassLoader().getResource(path);
        System.out.println(path);
        ImageIcon icon = new ImageIcon(url);
        icon.setImage(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icon);
    }
}
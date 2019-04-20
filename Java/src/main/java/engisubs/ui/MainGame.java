package engisubs.ui;


import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import engisubs.gameobject.*;
import engisubs.gameobject.GameObject.GameObjectType;
import engisubs.gameobject.cell.*;
import engisubs.gameobject.cell.land.*;

public class MainGame {
    private JFrame frame;
    private Game mainGame = null;
    private JPanel panel = null;

    public MainGame() {
        /*
        String path = new File("engisubs/ui/ASSETS/tilesets/coop-ungrown.png").getAbsolutePath();
        System.out.println(path);
        */

        //String path = "engisubs/ui/ASSETS/tilesets/ungrowed.png";
        mainGame = new Game();

        frame = new JFrame();
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");

        Font font  = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        
        up.setFont(font);
        up.setBounds(1020,250,60,40);
        up.setBackground(Color.white);

        down.setFont(font);
        down.setBounds(1020,350,60,40);
        down.setBackground(Color.white);

        left.setFont(font);
        left.setBounds(930,300,60,40);
        left.setBackground(Color.white);

        right.setFont(font);
        right.setBounds(1110,300,60,40);
        right.setBackground(Color.white);

        /**
         * Mengeset layout Panel di dalam frame.
         */
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 0,0));

        initPanel();
        
        //frame.getContentPane().add(panel,BorderLayout.PAGE_START);
        frame.setSize(1280,960);
        frame.setTitle("Engi's Farm by AwSubs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(up);
        frame.add(down);
        frame.add(left);
        frame.add(right);
  
        frame.setVisible(true);
    }

    /**
     * Mengeset besar(size) Panel di dalam frame.
     */
    private void initPanel(){
        if (panel != null){
            frame.remove(panel);
            panel = null;
        }

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(80 * mainGame.getRowCount(), 80 * mainGame.getColCount()));
        panel.setLayout(new GridLayout(mainGame.getRowCount(), mainGame.getColCount()));
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        try {
            for (int i = 0; i < mainGame.getRowCount(); i++){
                for (int j = 0; j < mainGame.getColCount(); j++){
                    if (mainGame.getCell(i, j).isWalkable()){
                        Land curToDraw = ((Land) mainGame.getCell(i, j));
                        if (curToDraw == null){
                            System.out.println("Null curToDraw");
                        }
                        CellPanel newCell = null;
                        if (curToDraw.isOccupied()){
                            newCell = new CellPanel(curToDraw.isGrown(), curToDraw.getObjectHere().getGameObjectType());
                        }else {
                            newCell = new CellPanel(curToDraw.isGrown(), GameObjectType.LAND);
                        }
                        panel.add(newCell);
                    }else {
                        Cell curToDraw = mainGame.getCell(i, j);
                        CellPanel newCell = new CellPanel(false, curToDraw.getGameObjectType());
                        panel.add(newCell);
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("GamePanel has " + panel.getComponents().length + " tiles.");
        frame.add(panel);
    }
}
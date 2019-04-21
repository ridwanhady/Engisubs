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
    private JPanel panelCommand = null;
    private JPanel panelStatus = null;
    private JFrame frame;
    private Game mainGame = null;
    private JPanel panel = null;
    private GridBagConstraints c;
    private Font font;
    private final int CELLSIZE = 60;

    public MainGame() {
        /*
        String path = new File("engisubs/ui/ASSETS/tilesets/coop-ungrown.png").getAbsolutePath();
        System.out.println(path);
        */

        //String path = "engisubs/ui/ASSETS/tilesets/ungrowed.png";
        mainGame = new Game();
        mainGame.startGame();
        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("engisubs/ui/ASSETS/KentuckyFriedChickenFont.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, 20);
        } catch (Exception e){
            e.printStackTrace();
        }
        frame = new JFrame();
        /**
         * Button command dasar pemain.
         */
        JButton up = addCommand("Up");
        JButton down = addCommand("Down");
        JButton left = addCommand("Left");
        JButton right = addCommand("Right");
        /**
         * Button command direction pemain.
         */
        JButton lu = addCommand("LU");
        JButton ld = addCommand("LD");
        JButton ll = addCommand("LL");
        JButton lr = addCommand("LR");

        /**
         * Button command interactable pemain.
         */
        JButton talk = addCommand("Talk");
        JButton grow = addCommand("Grow");
        JButton interact = addCommand("Interact");
        JButton kill = addCommand("Kill");
        /**
         * Mengeset layout Panel di dalam frame.
         */
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 0,0));

        initPanel();

        panelStatus = new JPanel();
        panelStatus.setPreferredSize(new Dimension(200,CELLSIZE*10));
        panelStatus.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
        panelStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JLabel tick = new JLabel("tick");
        panelStatus.add(tick);
    
        frame.add(panelStatus);

        panelCommand = new JPanel();
        panelCommand.setPreferredSize(new Dimension(1150,100));
        panelCommand.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets.top = -30;   
        c.insets.left = 5;
        c.insets.right = 5;

        panelCommand.add(up,c);
        panelCommand.add(down,c);
        panelCommand.add(left,c);
        panelCommand.add(right,c);

        panelCommand.add(lu,c);
        panelCommand.add(ld,c);
        panelCommand.add(ll,c);
        panelCommand.add(lr,c);

        panelCommand.add(talk,c);
        panelCommand.add(grow,c);
        panelCommand.add(interact,c);
        panelCommand.add(kill,c);

        frame.add(panelCommand);
        frame.setSize(1150,900);
        frame.setTitle("Engi's Farm by AwSubs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }

    /**
     * Mengeset besar(size) Panel di dalam frame.
     */
    private void initPanel(){
        if (panel != null){
            frame.remove(panel);
            System.out.println("INVALIDATE TEST");
            panel.invalidate();
            System.out.println("INVALIDATE TEST 2");
            panel = null;
            System.out.println("INVALIDATE TEST 3");
        }

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(CELLSIZE * mainGame.getRowCount(), CELLSIZE * mainGame.getColCount()));
        panel.setLayout(new GridLayout(mainGame.getRowCount(), mainGame.getColCount()));
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        try {
            for (int i = 0; i < mainGame.getRowCount(); i++){
                for (int j = 0; j < mainGame.getColCount(); j++){
            System.out.println(i + " " + j);
                    if (mainGame.getCell(i, j).isWalkable()){
                        Land curToDraw = ((Land) mainGame.getCell(i, j));
                        if (curToDraw == null){
                            System.out.println("Null curToDraw");
                        }
                        CellPanel newCell = null;
                        if (curToDraw.isOccupied()){
                            newCell = new CellPanel(curToDraw.isGrown(), curToDraw.getObjectHere(), CELLSIZE);
                        }else {
                            newCell = new CellPanel(curToDraw.isGrown(), curToDraw, CELLSIZE);
                        }
                        panel.add(newCell);
                    }else {
                        Cell curToDraw = mainGame.getCell(i, j);
                        CellPanel newCell = new CellPanel(false, curToDraw, CELLSIZE);
                        panel.add(newCell);
                    }
                }
            }
            panel.validate();
            System.out.println("VALIDASI");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("GamePanel has " + panel.getComponents().length + " tiles.");
        frame.add(panel);
    }
    
    private void addGB(JPanel panel, Component component, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(component, c);
    }
    /**
     * Melakukan kustomisasi pada JButton
     * @param button JButton yang ingin dikustomisasi
     */
    private void setButton (JButton button) {
        button.setFont(font);
        button.setBackground(Color.yellow);
    }
    /**
     * Membuat sebuah JButton yang berisikan command
     * @param  command Command yang direpresentasikan JButton tersebut
     * @return         JButton
     */
    private JButton addCommand(String command){
        JButton temp = new JButton(command);
        temp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                mainGame.gameHandler(command.toUpperCase());
                initPanel();
                frame.remove(panelCommand);
                frame.remove(panelStatus);
                frame.add(panelStatus);
                frame.add(panelCommand);
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        setButton(temp);
        return temp;
    }
}
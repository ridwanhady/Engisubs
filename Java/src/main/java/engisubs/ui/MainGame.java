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
    private GridBagConstraints c;
    private Font font;

    public MainGame() {
        /*
        String path = new File("engisubs/ui/ASSETS/tilesets/coop-ungrown.png").getAbsolutePath();
        System.out.println(path);
        */

        //String path = "engisubs/ui/ASSETS/tilesets/ungrowed.png";
        mainGame = new Game();

        frame = new JFrame();
        /**
         * Button command dasar pemain.
         */
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
        /**
         * Button command direction pemain.
         */
        JButton lu = new JButton("LU");
        JButton ld = new JButton("LD");
        JButton ll = new JButton("LL");
        JButton lr = new JButton("LR");

        /**
         * Button command interactable pemain.
         */
        JButton talk = new JButton("Talk");
        JButton grow = new JButton("Grow");
        JButton interact = new JButton("Interact");
        JButton kill = new JButton("Kill");

        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("engisubs/ui/ASSETS/KentuckyFriedChickenFont.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, 20);
        } catch (Exception e){
			e.printStackTrace();
		}
        
        /**
         * Mengeset layout Panel di dalam frame.
         */
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.LEADING, 0,0));

        initPanel();

        JPanel panelStatus = new JPanel();
        panelStatus.setPreferredSize(new Dimension(200,800));
        panelStatus.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
        panelStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JLabel tick = new JLabel("tick");
        panelStatus.add(tick);
    

        frame.add(panelStatus);
        
        JPanel panelCommand = new JPanel();
        panelCommand.setPreferredSize(new Dimension(1150,100));
        panelCommand.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.insets.top = -30;   
        c.insets.left = 5;
        c.insets.right = 5;


        setButton(up);
        setButton(down);
        setButton(left);
        setButton(right);

        setButton(lu);
        setButton(ld);
        setButton(ll);
        setButton(lr);

        setButton(talk);
        setButton(grow);
        setButton(interact);
        setButton(kill);


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
    
    void addGB(JPanel panel, Component component, int x, int y) {
        c.gridx = x;
        c.gridy = y;
        panel.add(component, c);
    }

    void setButton (JButton button) {
        button.setFont(font);
        button.setBackground(Color.yellow);
    }

}
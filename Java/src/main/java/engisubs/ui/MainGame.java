package engisubs.ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import engisubs.gameobject.Game;
import engisubs.gameobject.cell.Cell;
import engisubs.gameobject.cell.land.Land;
import engisubs.exception.InvalidCommandException;

public class MainGame {
    private JPanel panelCommand = null;
    private JPanel panelStatus = null;
    private JFrame frame;
    private Game mainGame = null;
    private JPanel panel = null;
    private GridBagConstraints c;
    private Font font;
    private final int CELLSIZE = 60;
    private String convoToWrite = "";
    private boolean gameOverShown = false;

    public MainGame() {
        mainGame = new Game();
        mainGame.startGame();
        try {
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("engisubs/ui/ASSETS/KentuckyFriedChickenFont.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, 15);
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

        initStatus();

        panelCommand = new JPanel();
        panelCommand.setPreferredSize(new Dimension(600,90));
        panelCommand.setLayout(new GridLayout(2,6));
        //c = new GridBagConstraints();
        //c.insets.top = 0;   
        //c.insets.left = 0;
        //c.insets.right = 0;

        panelCommand.add(up);
        panelCommand.add(down);
        panelCommand.add(left);
        panelCommand.add(right);

        panelCommand.add(lu);
        panelCommand.add(ld);
        panelCommand.add(ll);
        panelCommand.add(lr);

        panelCommand.add(talk);
        panelCommand.add(grow);
        panelCommand.add(interact);
        panelCommand.add(kill);

        frame.add(panelCommand);
        frame.setSize(800,720);
        frame.setTitle("Engi's Farm by AwSubs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
    }

    private void initStatus(){
        if (panelStatus != null){
            frame.remove(panelStatus);
        }

        panelStatus = new JPanel();
        panelStatus.setPreferredSize(new Dimension(200,CELLSIZE*10));
        panelStatus.setLayout(new FlowLayout(FlowLayout.LEADING,10,0));
        panelStatus.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        JLabel name = new JLabel("Name: " + mainGame.getPlayer().getName());
        panelStatus.add(name);

        JLabel water = new JLabel("Water: " + mainGame.getPlayer().getWater());
        panelStatus.add(water);

        JLabel money = new JLabel("Money: " + mainGame.getPlayer().getUang());
        panelStatus.add(money);

        JLabel inventori = new JLabel("Inventori:");
        panelStatus.add(inventori);

        JTextArea textarea = new JTextArea(5,20);
        for (int i = 0; i < mainGame.getPlayer().getInventory().size(); i++){
            textarea.append("[" + (i + 1) + "] " + mainGame.getPlayer().getInventory().get(i).getProductName() + "\n");
        }
        
        panelStatus.add(textarea);

        JLabel interactables = new JLabel("Conversation:");
        panelStatus.add(interactables);

        JTextArea interact_textarea = new JTextArea(5,20);
        interact_textarea.append(mainGame.getPlayer().lastConvo);
        panelStatus.add(interact_textarea);
    
        frame.add(panelStatus);
    }

    /**
     * Mengeset besar(size) Panel di dalam frame.
     */
    private void initPanel(){
        if (panel != null){
            frame.remove(panel);
            panel.invalidate();
            panel = null;
        }

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(CELLSIZE * mainGame.getRowCount(), CELLSIZE * mainGame.getColCount()));
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
                            newCell = new CellPanel(curToDraw.isGrown(), curToDraw, CELLSIZE);
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
                if (!mainGame.isGameOver()) {
                    mainGame.gameHandler(command.toUpperCase());
                    initPanel();
                    initStatus();
                    frame.remove(panelCommand);
                    frame.remove(panelStatus);
                    frame.add(panelStatus);
                    frame.add(panelCommand);
                    SwingUtilities.updateComponentTreeUI(frame);
                }
                if (mainGame.isGameOver()){
                    if (!gameOverShown){
                        gameOverHandler();
                        gameOverShown = true;
                    }
                }
            }
        });
        setButton(temp);
        return temp;
    }

    private void gameOverHandler(){
        JFrame gameOverFrame = new JFrame("Game Over");
        JPanel gameOverPanel = new JPanel();
        
        gameOverFrame.setSize(600, 400);
        gameOverFrame.setResizable(false);

        JLabel gameOverText = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverText.setFont(new Font(font.getFontName(), Font.PLAIN, 100));

        JLabel gameOverMessage = new JLabel("Kamu cupu!", SwingConstants.CENTER);
        gameOverMessage.setFont(new Font(font.getFontName(), Font.PLAIN, 50));

        gameOverPanel.add(gameOverText);
        gameOverPanel.add(gameOverMessage);
        gameOverFrame.add(gameOverPanel);

        gameOverFrame.setVisible(true);
    }
}
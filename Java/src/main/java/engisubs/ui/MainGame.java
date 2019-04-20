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

public class MainGame {
    private JFrame frame;
    private GridBagConstraints c;
    private Font font;
    public MainGame() {

        frame = new JFrame();
        /**
         * Button command dasar pemain.
         */
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");

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

        /**
         * Mengeset besar(size) Panel di dalam frame.
         */
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(880, 800));
        panel.setLayout(new GridLayout(10,11));
        
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        try {
            for (int i = 0 ; i < 110 ; i++) {
                //JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File(path))));
                //JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(path)));
                panel.add(new CellPanel(false));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        frame.add(panel);

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
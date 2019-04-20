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

    public MainGame() {
        /*
        String path = new File("engisubs/ui/ASSETS/tilesets/ungrowed.png").getAbsolutePath();
        System.out.println(path);
        */

        String path = "engisubs/ui/ASSETS/tilesets/ungrowed.png";

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
        


        /**
         * Mengeset besar(size) Panel di dalam frame.
         */
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(880, 800));
        panel.setLayout(new GridLayout(10,11));
        
        panel.setBackground(Color.red);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        try {
            for (int i = 0 ; i < 110 ; i++) {
                //JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File(path))));
                JLabel label = new JLabel(new ImageIcon(getClass().getClassLoader().getResource(path)));
                panel.add(label);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //panel.add(new JLabel("Button 2"));
        //panel.add(new JLabel("Button 3"));
        //panel.add(new JLabel("Button 4"));
        //panel.add(new JLabel("Button 5"));
        //panel.add(new JLabel("Button 6"));
        //panel.add(new JLabel("Button 7"));
        //panel.add(new JLabel("Button 8"));
        //panel.add(new JLabel("Button 9"));
        //panel.add(new JLabel("Button 10"));
        //panel.add(new JLabel("Button 11"));
    
        frame.add(panel);

        //frame.getContentPane().add(panel,BorderLayout.PAGE_START);
        frame.setSize(1280,960);
        frame.setTitle("Engi's Farm by AwSubs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(up);
        frame.add(down);
        frame.add(left);
        frame.add(right);
        //frame.add(up); 

        //frmClass.add(down);
        //frmClass.add(left);
        //frmClass.add(right);
  
        frame.setVisible(true);
    
    }

}
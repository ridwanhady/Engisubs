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
    private JFrame frmClass;

    public static void LaunchGame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    MainGame window = new MainGame();
                    window.frmClass.setVisible(true);
                } catch  (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainGame() {

        frmClass = new JFrame();
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

        
        frmClass.setSize(1280,720);
        frmClass.setTitle("Engi's Farm by AwSubs");
        frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClass.add(up); 
        frmClass.add(down);
        frmClass.add(left);
        frmClass.add(right);
        frmClass.setLayout(null);
    }

}
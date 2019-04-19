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
        JButton up = new JButton("Up");
        Font up_font  = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        up.setFont(up_font);
        up.setBounds(1000,50,100,50);
        up.setBackground(Color.white);

        frmClass = new JFrame();
        frmClass.setSize(1280,720);
        frmClass.setTitle("Engi's Farm by AwSubs");
        frmClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClass.add(up); 
    }

}
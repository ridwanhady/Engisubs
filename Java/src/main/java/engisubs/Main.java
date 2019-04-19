package engisubs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import engisubs.gameobject.*;
public class Main {
    
    public static void main(String args[]){
        JFrame f = new JFrame();
        
        //Background Image + logo
        try {
            //f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\acer\\Documents\\Engisubs-master\\Java\\src\\engisubs\\data\\engisubs_bg+logo.jpg")))));
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("./engisubs/data/engisubs_bg+logo.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }        
        
        //Background Music
        try {
			AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("./engisubs/data/engisubs_bgm.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(bgm);
			clip.start();
		}
		catch(Exception e){e.printStackTrace();}
        
        //Label Menu
        try {
			Font font1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("./engisubs/data/KentuckyFriedChickenFont.ttf"))).deriveFont(Font.PLAIN, 24);
			JButton start = new JButton("START GAME");
			start.setFont(font1);
			start.setBounds(220,275,200,40);
			start.setBackground(Color.yellow);
			JButton exit = new JButton("EXIT GAME");
			exit.setFont(font1);
			exit.setBounds(220,330,200,40);
			exit.setBackground(Color.yellow);
			f.add(start);
			f.add(exit);
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
        
        //Credit
        JButton credit = new JButton("Credit");
        Font credit_font  = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        credit.setBounds(500,10,80,30);
        credit.setFont(credit_font);
        credit.setBackground(Color.white);
        f.add(credit);    
 
        f.setSize(640,480);
        f.setTitle("Engi's Farm by AWSubs");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        //System.out.println("Starting...");
        //Game newGame = new Game();
        //newGame.startGame();
        //newGame.gameLoop();

    }
}

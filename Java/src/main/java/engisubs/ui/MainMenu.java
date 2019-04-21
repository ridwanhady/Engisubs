package engisubs.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import engisubs.gameobject.*;
public class MainMenu extends JFrame {
    private Clip clip;
    public MainMenu() {
        super();

        JFrame f = new JFrame();
    
        //Background Image + logo
        try {

            //f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("engisubs/ui/ASSETS/engisubs_bg+logo.jpg")))));
            f.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("engisubs/ui/ASSETS/engisubs_bg+logo.jpg"))));
            //f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\acer\\Documents\\Engisubs-master\\Java\\src\\engisubs\\data\\engisubs_bg+logo.jpg")))));
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        //Background Music
        try {
            //AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("engisubs/ui/ASSETS/engisubs_bgm.wav"));
            AudioInputStream bgm = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("engisubs/ui/ASSETS/engisubs_bgm.wav"));
			//AudioInputStream bgm = AudioSystem.getAudioInputStream(new File("C:\\Users\\acer\\Documents\\Engisubs-master\\Java\\src\\engisubs\\data\\engisubs_bgm.wav"));
			clip = AudioSystem.getClip();
			clip.open(bgm);
			clip.start();
		}
		catch(Exception e){e.printStackTrace();}
        
        //Label Menu
        try {
            //Font font1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("engisubs/ui/ASSETS/KentuckyFriedChickenFont.ttf"))).deriveFont(Font.PLAIN, 24);
            InputStream fontStream = getClass().getClassLoader().getResourceAsStream("engisubs/ui/ASSETS/KentuckyFriedChickenFont.ttf");
            Font font1 = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, 24);
			//Font font1 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("C:\\Users\\acer\\Documents\\Engisubs-master\\Java\\src\\engisubs\\data\\KentuckyFriedChickenFont.ttf"))).deriveFont(Font.PLAIN, 24);
			JButton start = new JButton("START GAME");
			start.setFont(font1);
			start.setBounds(220,275,200,40);
            start.setBackground(Color.yellow);
            start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    MainGame MG = new MainGame();
                    clip.close();
                }
            });
			JButton exit = new JButton("EXIT GAME");
			exit.setFont(font1);
			exit.setBounds(220,330,200,40);
            exit.setBackground(Color.yellow);
            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0) {
                    f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                }
            });
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

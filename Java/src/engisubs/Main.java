package engisubs;

import javax.swing.*;
import engisubs.gameobject.*;
public class Main{
    
    public static void main(String args[]){
        JFrame f = new JFrame();
        JButton b =new JButton("click");
        b.setBounds(130,100,100,40);
        f.add(b);
        f.setSize(1000,600);
        f.setLayout(null);
        f.setVisible(true);
        //System.out.println("Starting...");
        //Game newGame = new Game();
        //newGame.startGame();
        //newGame.gameLoop();
    }
}
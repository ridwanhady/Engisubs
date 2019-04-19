package engisubs.ui;
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu();
            }

        });
    }
}

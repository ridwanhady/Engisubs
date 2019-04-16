package engisubs;

import javax.swing.*;
import engisubs.gameobject.*;
class Main{
    
    static public void main(String args[]){
        System.out.println("Starting...");
        Game newGame = new Game();
        newGame.startGame();
        newGame.gameLoop();
    }
    
}
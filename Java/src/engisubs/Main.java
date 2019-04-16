package engisubs;

import javax.swing.*;
import engisubs.gameobject.*;
class Main{
    
    static public void main(String args[]){
        Game newGame = new Game();
        newGame.startGame();
        newGame.gameLoop();
    }
    
}
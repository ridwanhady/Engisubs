package engisubs.ui;

import javax.swing.*;

import engisubs.gameobject.Player;

class StatusWindow extends JFrame{
    private Player p = null;

    public StatusWindow(Player _p){
        p = _p;
        JLabel titleBar = new JLabel("Status:");
        JLabel nameBar = new JLabel("Nama: " + p.getName());
        
    }
}
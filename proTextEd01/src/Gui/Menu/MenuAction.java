package Gui.Menu;

import Gui.SuperFrame;
import Text.TextField;

import javax.swing.JOptionPane;

/*
    Action to top Menu
*/
public class MenuAction {
    private SuperFrame superFrame;
    
    public MenuAction() {
       this.superFrame = SuperFrame.getInstance();    
    }
   
    public void about(SuperFrame superFrame){
        JOptionPane jp = new JOptionPane();
            jp.showMessageDialog(null,"Mikael Englund is the lovely author.");
    }
}

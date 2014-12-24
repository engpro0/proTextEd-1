package protexted01;

import Gui.Menu.Menu;
import Gui.SuperFrame;
import Text.TextField;
import java.awt.GraphicsEnvironment;

public class ProTextEd01 {
   
    private static Menu menu;

    public static void main(String[] args) {
       SuperFrame superFrame = SuperFrame.getInstance();
       menu = new Menu();
       
       String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
       for (String font : fonts)
           System.out.println(font);
       superFrame.setVisible(true);
       
    }
    
}

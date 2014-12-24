
package Gui.Menu.Font;

import Gui.SuperFrame;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public final class FontMenu implements ActionListener {
    private JMenu font = new JMenu();
    private SuperFrame superFrame;
    private JMenuItem [] fontItems;
    
    public FontMenu() {
        this.superFrame = SuperFrame.getInstance();
        String [] fonts = getAllFonts();
        this.fontItems = new JMenuItem[fonts.length];
        for (int i = 0; i < fonts.length; i++) { 
            this.fontItems[i] = new JMenuItem();
            this.fontItems[i].setText(fonts[i]);
            this.fontItems[i].addActionListener(this);
            this.font.add(this.fontItems[i]);           
        }
        this.font.setText("Font");       
    }
   
    public JMenu getFontMenu() {
        return this.font;
    }   
    public String [] getAllFonts() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String [] fonts = getAllFonts();
        for (int i = 0; i < fonts.length; i++){
            if (e.getSource() == this.fontItems[i]){
                superFrame.setFontName(fonts[i]); 
            }
        }
    }               
}

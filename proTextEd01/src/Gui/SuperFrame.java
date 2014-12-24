
package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/*
    The Main window parent of the program.
*/
public class SuperFrame extends JFrame{
    private static SuperFrame uniqueInstance = new SuperFrame(); //
    private JTextArea textArea = new JTextArea();
    private JScrollPane areaScrollPane;
    private String fontName;
    
    private int size = 12;
    
    private SuperFrame() {
        //init window
        this.setSize(500, 300);
        this.setTitle("ProTextEd vs 0.1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.fontName = "Century Gothic";
        this.setFontName(this.fontName);
	this.textArea.setDragEnabled(true);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(textArea);
        
        this.areaScrollPane = new JScrollPane(textArea);
	this.areaScrollPane.setVerticalScrollBarPolicy(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	this.areaScrollPane.setHorizontalScrollBarPolicy(
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	this.areaScrollPane.setPreferredSize(new Dimension(250, 250));
        this.getContentPane().add(areaScrollPane);
 
        String [] choices = {"Adobe Arabic", "ch2", "ch3"};
        final JComboBox<String> cb = new JComboBox<String>(choices);
        cb.setVisible(true);
        //this.panel.setPreferredSize(new Dimension(30,30));
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 10;
        
        
        ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) cb.getSelectedItem();
                switch (s) {
                    case "Adobe Arabic":
                        setFontName("Adobe Arabic");
                }
            }
        };
        cb.addActionListener(cbActionListener);
    }
    public void setFontName(String fontName) {
        this.fontName = fontName;
        this.textArea.setFont(new Font(fontName, Font.PLAIN, this.size+10));
    }
    public static SuperFrame getInstance() //uses singelton pattern to ensure only one instance
    {
        return uniqueInstance;
    }
    public JTextArea getTextArea() {
        return this.textArea;
    }
 
}

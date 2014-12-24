package Text;

import Gui.SuperFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
    Textfield for the area you write text
*/
public class TextField {
    private SuperFrame superFrame;
    private JTextArea textArea = new JTextArea();
    private JScrollPane areaScrollPane;
    
    public TextField() {
        this.superFrame = SuperFrame.getInstance();
        this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));
	this.textArea.setDragEnabled(true);
        
        superFrame.getContentPane().setLayout(new BorderLayout());
        superFrame.getContentPane().add(textArea);
        
        this.areaScrollPane = new JScrollPane(textArea);
	this.areaScrollPane.setVerticalScrollBarPolicy(
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	this.areaScrollPane.setHorizontalScrollBarPolicy(
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	this.areaScrollPane.setPreferredSize(new Dimension(250, 250));
        superFrame.getContentPane().add(areaScrollPane);
    }
    public JTextArea getTextArea() {
        return this.textArea;
    }

   
    
}

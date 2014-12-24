
package Gui.Menu;

import Gui.Menu.Font.FontMenu;
import Gui.Menu.File.File;
import Gui.SuperFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/*
    The top menu on the main window
*/
public final class Menu implements ActionListener {
    
    private SuperFrame superFrame;
    private MenuAction topMenuAction;
    private File file;
    private FontMenu font;
    
    private JMenuBar menuBar = new JMenuBar();	
    
    private JMenu edit = new JMenu();
    private JMenu format = new JMenu();
    private JMenu view = new JMenu();
    private JMenu help = new JMenu();
    
    private JMenuItem undo = new JMenuItem();
    private JMenuItem cut = new JMenuItem(new DefaultEditorKit.CutAction());
    private JMenuItem copy = new JMenuItem(new DefaultEditorKit.CopyAction());
    private JMenuItem paste = new JMenuItem(new DefaultEditorKit.PasteAction());
    private JMenuItem delete = new JMenuItem();
    private JMenuItem wordwrap = new JMenuItem();
    private JMenuItem about = new JMenuItem();
    
    public Menu(){
        this.superFrame = SuperFrame.getInstance();
        
        this.topMenuAction = new MenuAction();
        
        
        this.font = new FontMenu();
        this.file = new File();
        
	
	this.edit.setText("Edit");
	this.format.setText("Format");
	this.view.setText("View");
	this.help.setText("Help");

	initMenuBar();
	
        initUndo();
        initCut();
	initCopy();
        initPaste();
        initAbout();
    }
   
    public void initMenuBar() {
        this.menuBar.add(this.file.getFileMenu());
	this.menuBar.add(this.edit);
	this.menuBar.add(this.help);
        this.menuBar.add(this.font.getFontMenu());
        superFrame.setJMenuBar(this.menuBar);
    }
    
    public void initUndo() {
        this.undo.setText("Undo");		
	this.undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
	this.undo.setMnemonic(KeyEvent.VK_U);
	this.undo.addActionListener(this);
	this.edit.add(this.undo);
        
    }
    public void initCut() {
        this.cut.setText("Cut");
	this.cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
	this.cut.setMnemonic(KeyEvent.VK_T);
	this.edit.add(this.cut); 
    }
    public void initCopy() {
        this.copy.setText("Copy");
	this.copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
	this.copy.setMnemonic(KeyEvent.VK_C);
	this.copy.addActionListener(this);
	this.edit.add(this.copy);
    }
    public void initPaste() {
        this.paste.setText("Paste");
	this.paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
	this.paste.setMnemonic(KeyEvent.VK_P);
	this.paste.addActionListener(this);
	this.edit.add(this.paste);
    }
    public void initAbout() {
        this.about.setText("Author");
	this.about.addActionListener(this);
	this.help.add(this.about);
    }

    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == this.about) {
            this.topMenuAction.about(this.superFrame);
        }
    }
    
}

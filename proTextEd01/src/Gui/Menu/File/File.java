package Gui.Menu.File;

import Gui.SuperFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public final class File implements ActionListener {

    private SuperFrame superFrame;

    private FileAction fileAction;
    
    private JMenu file = new JMenu();
    private JMenuItem newFile = new JMenuItem();
    private JMenuItem openFile = new JMenuItem();
    private JMenuItem saveFile = new JMenuItem();
    private JMenuItem close = new JMenuItem();
    
    public File() {
        this.superFrame = SuperFrame.getInstance();
        this.fileAction = new FileAction();
        this.file.setText("file");
        initNewFile();
        initOpenFile();
        initSaveFile();
        initClose();
    }
    public JMenu getFileMenu() {
        return this.file;
    }
            
    public void initNewFile() {
        this.newFile.setText("New");
	this.newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
	this.newFile.addActionListener(this);
        this.newFile.setMnemonic(KeyEvent.VK_N);
	this.file.add(this.newFile);
    }
    public void initOpenFile() {
        this.openFile.setText("Open");
	this.openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
	this.openFile.addActionListener(this);
	this.openFile.setMnemonic(KeyEvent.VK_O);
	this.file.add(this.openFile);
        
    }
    public void initSaveFile() {
        this.saveFile.setText("Save");
	this.saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
	this.saveFile.addActionListener(this);
	this.saveFile.setMnemonic(KeyEvent.VK_S);
	this.file.add(this.saveFile);
    }
    public void initClose() {
        this.close.setText("Close");
	this.close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.CTRL_MASK));
	this.close.setMnemonic(KeyEvent.VK_F4);
	this.close.addActionListener(this);
	this.file.add(this.close);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        if (e.getSource() == this.close) {
            superFrame.dispose();
        }
	else if (e.getSource() == this.openFile) {
            this.fileAction.openFile();
        }
        
        else if (e.getSource() == this.saveFile) {
            this.fileAction.openFile();
	}
        
	else if (e.getSource() == this.newFile) {
            this.fileAction.newFile();
	} 
    }
}


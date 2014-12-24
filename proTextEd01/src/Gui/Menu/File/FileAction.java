package Gui.Menu.File;

import Gui.SuperFrame;
import Text.TextField;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileAction {
    private SuperFrame superFrame;
    
    public FileAction() {
        this.superFrame = SuperFrame.getInstance();
    }
    
     public void openFile() {
        JFileChooser open = new JFileChooser();
        int option = open.showOpenDialog(superFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            superFrame.getTextArea().setText("");
            try {
                Scanner scan = new Scanner(new FileReader(open
					   .getSelectedFile().getPath()));
                while (scan.hasNext())
                    superFrame.getTextArea().append(scan.nextLine() + "\n");
		} 
            catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
        } 
    }
    
    public void saveFile() {
        JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(superFrame);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(save
							.getSelectedFile().getPath()));
                    out.write(superFrame.getTextArea().getText());
                    out.close();
		} catch (Exception ex) {
                    System.out.println(ex.getMessage());
            }
        }
    }
    public void newFile() {
        JOptionPane jp = new JOptionPane();
            Object[] options = { "Save", "Don't Save", "Cancel" };
            int button = jp.showOptionDialog(null,
                "Do you want to save changes to" + superFrame.getTitle(), "proTextEd",
		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
		null, options, options[0]);
            
            if (button == 0) {
                JFileChooser newFile = new JFileChooser();
                int option = newFile.showSaveDialog(superFrame);
		if (option == JFileChooser.APPROVE_OPTION) {
                    try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
			newFile.getSelectedFile().getPath()));
			out.write(superFrame.getTextArea().getText());
                        out.close();
                    } catch (Exception ex) {
			System.out.println(ex.getMessage());
                    }
		}
            } else if (button == 1) {
		superFrame.getTextArea().setText(null);
            } else if (button == 2) {

        }
    }
    
}

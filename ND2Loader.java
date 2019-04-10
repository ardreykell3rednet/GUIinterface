import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ND2Loader extends JPanel
                             implements ActionListener {
    static private final String newline = "\n";
    JButton openButton, confirmButton;
    JTextArea log;
    JFileChooser fc;
    File file;
    private char purpose;
    public ND2Loader() {
        super(new BorderLayout());
        log = new JTextArea();
        log.setMargin(new Insets(10,10,10,10));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        fc = new JFileChooser();
        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);
        confirmButton = new JButton("CONFIRM");
        confirmButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(); 
        buttonPanel.add(openButton);
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
        JFrame frame = new JFrame("ND2Loader");
        frame.setTitle("File Loader");
        frame.setBounds(100, 100, 751, 708);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(log);
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openButton) {
        	fc.addChoosableFileFilter(new ImageFilter());
            fc.setAcceptAllFileFilterUsed(false);
            int returnVal = fc.showOpenDialog(ND2Loader.this);
            file = fc.getSelectedFile();
            log.setCaretPosition(log.getDocument().getLength());
            openButton.setText(file.getName());
        } else if (e.getSource() == confirmButton) {
        	if (file != null && purpose == 'T'){
        		//RoiTrain roitrain = new RoiTrain(returnFile(file));
        	}
        	if (file != null && purpose == 'I') {
        		//Ident ident = new Ident (returnFile(file));
        	}
        } else {
        	return;
        }
    }
    public File returnFile(File f) {
    	return f;
    }
    public void setPurpose(char p) {
    	purpose = p;
    }
}
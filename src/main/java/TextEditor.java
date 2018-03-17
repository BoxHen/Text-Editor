package main.java;

import javax.swing.*;
import java.awt.*;


// try with java fx too
public class TextEditor extends JFrame { // JFrame is from Package javax.swing and is An extended version of
    // java.awt.Frame that adds support for the JFC/Swing component architecture.
    // A Frame is a top-level window with a title and a border.
/*================================================Base variables======================================================*/
/*-------------------- part of javax.swing-------------------------*/
    private JTextArea area = new JTextArea(20,120); // JTextArea will be the area where you can write documents
    // The two arguments to the JTextArea constructor are the number of rows and columns, respectively, that the text area should display
    private JFileChooser dialog = new JFileChooser(System.getProperty("user.dir")); // JFileChooser provides a simple mechanism for the user to choose a file.
    // reference: https://docs.oracle.com/javase/tutorial/uiswing/components/filechooser.html
/*-----------------------------------------------------------------*/
    private String currentFile = "Untitled";
    private boolean changed = false;
/*====================================================================================================================*/

    public TextEditor() {
        area.setFont(new Font("Monospaced", Font.PLAIN, 12)); //setFont is part of JTextArea
        JScrollPane areaScrollPane = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // sets up scroll bar policy
        add(areaScrollPane, BorderLayout.CENTER); // adds the scroll pane to the container

        JMenuBar JMB = new JMenuBar(); // creates menu drop down
        setJMenuBar(JMB);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMB.add(file);
        JMB.add(edit);

    }
}


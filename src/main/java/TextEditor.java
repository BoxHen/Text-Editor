package main.java;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.io.IOException;


// try with java fx too
public class TextEditor extends JFrame { // JFrame is from Package javax.swing and is An extended version of
    // java.awt.Frame that adds support for the JFC/Swing component architecture.
    // A Frame is a top-level window with a title and a border.
/*================================================Base variables======================================================*/
/*-------------------- part of javax.swing-------------------------*/
    private JTextArea area = new JTextArea(20, 120); // JTextArea will be the area where you can write documents
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

        JMenuBar JMB = new JMenuBar(); // creates bar
        setJMenuBar(JMB); // adds bar to the frame (ex. file edit view navigate code ...)
        JMenu file = new JMenu("File"); // creates a tab called file
        JMenu edit = new JMenu("Edit"); // creates a tab called edit
        JMB.add(file); // adds tabs to the bar
        JMB.add(edit);

        /*file.add(New);*/
        file.add(Open);
        file.add(Save);
        file.add(Quit);
        file.add(SaveAs); // refer below
        file.addSeparator(); // creates a line in file dropdown after the SaveAs

        for (int i = 0; i < 4; i++) {
            file.getItem(i).setIcon(null); //Returns the item affected by the event.
        }
        edit.add(Cut);
        edit.add(Copy);
        edit.add(Paste);

        edit.getItem(0).setText("Cut out"); // ????
        edit.getItem(1).setText("Copy"); // setText is used to change the  display text  of a component like label, text field or button  at run time
        edit.getItem(2).setText("Paste");

        JToolBar tool = new JToolBar(); // Creates a new tool bar; orientation defaults to HORIZONTAL.
        add(tool, BorderLayout.NORTH); // add toolbar to the frame and sets it up top
        /*tool.add(New);*/
        tool.add(Open);
        tool.add(Save);
        tool.addSeparator();

        JButton cut = tool.add(Cut), cop = tool.add(Copy), pas = tool.add(Paste);

        /*cut.setText("cut");*/
        cut.setIcon(new ImageIcon("cut.png")); // how do i ref the resources folder???????
        cop.setText("copy");
        cop.setIcon(new ImageIcon("copy.png"));
        pas.setText("paste");
        pas.setIcon(new ImageIcon("paste.png"));

        Save.setEnabled(false);
        SaveAs.setEnabled(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack(); //packs the components within the window based on the component’s preferred sizes (w/o this window was small initially)
        area.addKeyListener(k1);
        setTitle(currentFile);
        setVisible(true);
    }

    //save and save as are initially grayed out until text is entered in the JTextArea
    private KeyListener k1 = new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            changed = true;
            Save.setEnabled(true);
            SaveAs.setEnabled(true);
        }
    };
    //action1
    Action Open = new AbstractAction("Open") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (dialog.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                readInFile(dialog.getSelectedFile().getAbsolutePath());
            }
            SaveAs.setEnabled(true);
        }
    };

    Action Save = new AbstractAction("Save") {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!currentFile.equals("Untitled"))
                saveFile(currentFile);
            else
                saveFileAs();
        }
    };

}




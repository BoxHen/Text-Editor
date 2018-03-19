package test.java;

import javax.swing.*;

public class BasicSwing extends JFrame {
    JPanel p = new JPanel();
    JButton b = new JButton("Click");
    JTextField t = new JTextField("Hi",20);
    JTextArea ta = new JTextArea("How\nare\nyou?",5,20);
    JLabel l = new JLabel("What's up?");

    String choice[] = {"hola","hi","Bonjour"};
    JComboBox c = new JComboBox(choice);



//    public static void main(String[] args){
//        new BasicSwing();
//    }

    public BasicSwing(){
        super("Basic Swing App"); // calls the super class constructor JFrame
                                // This is title of the window
        setSize(800,600);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p.add(b); // add button to the panel
        p.add(t);
        p.add(ta);
        p.add(l);
        p.add(c);
        add(p); // add p to jFrame

        setVisible(true);
    }
}



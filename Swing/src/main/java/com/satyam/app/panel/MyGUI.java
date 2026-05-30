package com.satyam.app.panel;

import javax.swing.*;

public class MyGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Dark theme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        JButton buttonOne = new JButton("I'm a JButton");
        panel.add(buttonOne);

        JLabel label = new JLabel("I'm a JLabel");
        panel.add(label);

        JTextArea textArea = new JTextArea("I'm a JTextArea");
        panel.add(textArea);

        JButton buttonTwo = new JButton("I'm another JButton!");
        panel.add(buttonTwo);

        frame.add(panel);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

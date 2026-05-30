package com.satyam.app.layout;

import javax.swing.*;
import java.awt.*;

public class MyGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Happy Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel leftPanel = new JPanel();
        BoxLayout leftBoxLayoutManager = new BoxLayout(leftPanel,BoxLayout.Y_AXIS);
        leftPanel.setLayout(leftBoxLayoutManager);

        leftPanel.add(new JButton("JButton One"));
        leftPanel.add(new JButton("JButton Two"));
        leftPanel.add(new JButton("JButton Three"));
        leftPanel.add(new JButton("JButton Four"));
        leftPanel.add(new JButton("JButton Five"));

        JPanel rightPanel = new JPanel();
        BoxLayout rightBoxLayoutManager = new BoxLayout(rightPanel,BoxLayout.Y_AXIS);
        rightPanel.setLayout(rightBoxLayoutManager);

        rightPanel.add(new JLabel("JLabel One"));
        rightPanel.add(new JLabel("JLabel Two"));
        rightPanel.add(new JLabel("JLabel Three"));
        rightPanel.add(new JLabel("JLabel Four"));
        rightPanel.add(new JLabel("JLabel Five"));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

package com.satyam.app.panel;

import javax.swing.*;
import java.awt.*;

public class DarkThemeDemo {

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        UIManager.put("control", new Color(60, 63, 65));
        UIManager.put("info", new Color(60, 63, 65));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusLightBackground", new Color(43, 43, 43));
        UIManager.put("text", Color.WHITE);

        JFrame frame = new JFrame("Dark Theme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Hello Dark World"));

        JButton button = new JButton("Click Me");
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
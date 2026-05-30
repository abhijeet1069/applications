package com.satyam.app.learning.layout.card;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo2{
    JPanel cards;
    final static String BUTTONPANEL = "Tab with JButtons";
    final static String TEXTPANEL = "Tab with JTextField";
    final static int extraWindowWidth = 100;

    public void addComponentToPane(Container pane){
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel card1 = new JPanel(){
          public Dimension getPreferredSize(){
              Dimension size = super.getPreferredSize();
              size.width += extraWindowWidth;
              return size;
          }
        };
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField",20));

        tabbedPane.addTab(BUTTONPANEL, card1);
        tabbedPane.addTab(TEXTPANEL, card2);

        pane.add(tabbedPane, BorderLayout.CENTER);
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("TabDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayoutDemo2 demo = new CardLayoutDemo2();
        demo.addComponentToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                CardLayoutDemo2::createAndShowGUI
        );
    }
}

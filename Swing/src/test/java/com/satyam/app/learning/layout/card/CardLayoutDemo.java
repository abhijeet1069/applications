package com.satyam.app.learning.layout.card;

import javax.swing.*;
import java.awt.*;

/**
CardLayout works like a stack of cards where only one card is visible at a time
 * */

public class CardLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CardLayout example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel homePanel = new JPanel();
        homePanel.add(new JLabel("Home Screen"));

        JPanel settingsPanel = new JPanel();
        settingsPanel.add(new JLabel("Settings Screen"));

        cardPanel.add(homePanel,"HOME");
        cardPanel.add(settingsPanel,"SETTINGS");

        JButton nextButton = new JButton("next");
        nextButton.addActionListener(e->
                cardLayout.next(cardPanel));

        frame.add(cardPanel,BorderLayout.CENTER);
        frame.add(nextButton,BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

package com.satyam.app.tool;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel cards;

    public MainFrame(){
        super("String Tool");
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        cards.add(new LengthPanel(),"LENGTH");
        cards.add(new PalindromePanel(),"PALINDROME");
        setJMenuBar(createMenuBar());
        add(cards);
        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Mode");
        JMenuItem lengthItem = new JMenuItem("Length");
        JMenuItem palindromeItem = new JMenuItem("Palindrome");

        lengthItem.addActionListener(
                e->cardLayout.show(cards,"LENGTH"));
        palindromeItem.addActionListener(
                e->cardLayout.show(cards,"PALINDROME"));

        menu.add(lengthItem);
        menu.add(palindromeItem);
        menuBar.add(menu);

        return menuBar;
    }
}

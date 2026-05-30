package com.satyam.app.tool;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PalindromePanel extends JPanel {
    private final JTextArea inputArea;
    private final JLabel resultLabel;

    public PalindromePanel(){
        setLayout(new BorderLayout(10,10));
        inputArea = new JTextArea(5,30);
        JButton button = new JButton("Check Palindrome");
        resultLabel = new JLabel("Result:");
        button.addActionListener(e->checkPalindrome());
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom,BoxLayout.Y_AXIS));

        bottom.add(button);
        bottom.add(Box.createVerticalStrut(10));
        bottom.add(resultLabel);

        add(new JScrollPane(inputArea), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

    private void checkPalindrome(){
        String text = inputArea.getText()
                .replaceAll("\\s+","")
                .toLowerCase();
        String reverse = new StringBuilder(text)
                .reverse()
                .toString();

        boolean palindrome = text.equals(reverse);

        resultLabel.setText("Result: "+(palindrome ? "Palindrome" : "Not Palindrome"));
    }
}

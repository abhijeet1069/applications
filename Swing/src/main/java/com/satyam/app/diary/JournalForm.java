package com.satyam.app.diary;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JournalForm {
    private static String savedText = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Journal");
        frame.setSize(400,300);
        JTextArea textArea = new JTextArea();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            savedText = textArea.getText();
            JOptionPane.showMessageDialog(
                    frame,
                    "Length: " + savedText.length(),
                    "Saved",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane,BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

package com.satyam.app.tool;

import javax.swing.*;
import java.awt.*;

public class LengthPanel extends JPanel{
    private final JTextArea inputArea;
    private final JLabel resultLabel;

    public LengthPanel() {
        setLayout(new BorderLayout(10,10));
        inputArea = new JTextArea(5,30);
        JButton button = new JButton("Calculate length");
        resultLabel = new JLabel("Length:");
        button.addActionListener(e->calculateLength());

        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom,BoxLayout.Y_AXIS));

        bottom.add(button);
        bottom.add(Box.createVerticalStrut(10));
        bottom.add(resultLabel);

        add(new JScrollPane(inputArea),BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
    }

    private void calculateLength() {
        String text = inputArea.getText();
        resultLabel.setText("Length: "+text.length());
    }
}

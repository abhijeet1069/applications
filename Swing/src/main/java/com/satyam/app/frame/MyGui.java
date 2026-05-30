package com.satyam.app.frame;

import javax.swing.*;
import java.awt.*;

public class MyGui
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Happy Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello World");
        label.setFont(new Font("Serif",Font.BOLD, 36));
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}

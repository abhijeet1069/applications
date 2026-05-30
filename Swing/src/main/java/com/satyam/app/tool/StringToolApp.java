package com.satyam.app.tool;

import javax.swing.SwingUtilities;

public class StringToolApp {
    public static void main(String[] args) {
        //Run this code on the UI thread, not main thread
        // main thread will exit but this will continue to run
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
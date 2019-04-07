package com.mengxk.obj;

import javax.swing.*;
import java.awt.event.ActionListener;


public class TimePrinterTest {
    public static void main(String[] args) {
        ActionListener actionListener = new TimePrinter();
        Timer timer = new Timer(1000, actionListener);
        timer.start();
        System.out.println("start");
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}
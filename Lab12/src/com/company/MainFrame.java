package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public static void main(String[] args) throws InterruptedException {
        MainFrame mainFrame = new MainFrame();
        DesignPanel designPanel = new DesignPanel();
        ControlPanel controlPanel = new ControlPanel(designPanel);
        controlPanel.setBounds(0,0,1000,50);
        designPanel.setBounds(0, 100, 1000,550);

        designPanel.addMouseListener(new Mouse(designPanel, controlPanel));
        mainFrame.setSize(1000, 600);
        mainFrame.add(controlPanel);
        mainFrame.add(designPanel);
        mainFrame.setVisible(true);

    }
}

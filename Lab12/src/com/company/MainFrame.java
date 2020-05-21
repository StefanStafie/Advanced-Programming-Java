package com.company;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class MainFrame extends JFrame implements Serializable {


    public static void main(String[] args) throws InterruptedException {

        JFrame details = new JFrame();
        details.setSize(300, 200);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setLayout(null);
        DesignPanel designPanel = new DesignPanel();
        ControlPanel controlPanel = new ControlPanel(designPanel, mainFrame);
        controlPanel.setBounds(0,50,1000,50);
        designPanel.setBounds(0, 200, 1000,550);



        designPanel.addMouseListener(new Mouse(designPanel, controlPanel, mainFrame));
        mainFrame.setSize(1000, 600);
        mainFrame.add(controlPanel);
        mainFrame.add(designPanel);
        mainFrame.setComponentZOrder(controlPanel,0);
        mainFrame.setComponentZOrder(designPanel,2);
        mainFrame.setVisible(true);


    }
    public static void setDesignPanel(DesignPanel x){

    }

}

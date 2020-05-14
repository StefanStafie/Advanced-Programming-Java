package com.company;

import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    JTextArea text;
    DesignPanel designPanel;
    public ControlPanel(DesignPanel designPanel) {
        this.designPanel= designPanel;
        this.setLayout(new GridBagLayout());
        text = new JTextArea(1,30);
        JButton select = new JButton("SELECT");
        //select.addActionListener(new SelectListener(this));
        text.setPreferredSize(new Dimension(350, 20));
        this.add(text);
        this.add(select);
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}

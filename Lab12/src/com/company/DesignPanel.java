package com.company;

import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    JTextArea text;

    public DesignPanel() {
        this.setLayout(null);
        this.setBackground(Color.DARK_GRAY);

    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}

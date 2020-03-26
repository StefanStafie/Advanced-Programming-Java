package com.company;
import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    JSpinner sizeField;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        String s[] = {"Blue", "Red"};
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(5, 3, 100, 1));
        colorCombo = new JComboBox(s);
        colorCombo.setBounds(50, 50,90,20);

        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JSpinner(new SpinnerNumberModel(5, 3, 1000, 1));
        colorCombo = new JComboBox(s);
        colorCombo.setBounds(50, 50,90,20);

        add(sizeLabel);
        add(sizeField);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }
}

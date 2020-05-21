package com.company;

import javafx.scene.layout.Border;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class ControlPanel extends JPanel implements Serializable {
    private final JButton saveBtn;
    private final JButton loadBtn;
    JTextArea text;
    DesignPanel designPanel;
    MainFrame mainFrame;
    JFrame details = new JFrame();
    JTable jTextArea = new JTable();
    public ControlPanel(DesignPanel designPanel, MainFrame mainFrame) {
        this.details.add(jTextArea);
        this.details.setVisible(true);

        this.mainFrame = mainFrame;
        this.designPanel = designPanel;
        this.setLayout(new GridBagLayout());
        text = new JTextArea(1, 30);
        JButton select = new JButton("SELECT");
        text.setPreferredSize(new Dimension(350, 20));
        this.add(text);
        this.add(select);

        saveBtn = new JButton("Save");
        loadBtn = new JButton("Load");
        add(saveBtn);
        add(loadBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
    }

    private void save(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            int userSelection = fileChooser.showSaveDialog(saveBtn);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                FileOutputStream fos = new FileOutputStream(fileToSave.getAbsolutePath());
                XMLEncoder encoder = new XMLEncoder(fos);
                encoder.setExceptionListener(new ExceptionListener() {
                    public void exceptionThrown(Exception e) {
                        System.out.println("Exception! :"+e.toString());
                    }
                });
                encoder.writeObject(designPanel);
                encoder.close();
                fos.close();

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void load(ActionEvent e) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to load");

            int userSelection = fileChooser.showSaveDialog(saveBtn);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();
                System.out.println("Load file: " + fileToLoad.getAbsolutePath());


                FileInputStream fis = new FileInputStream(fileToLoad.getAbsolutePath());
                XMLDecoder decoder = new XMLDecoder(fis);
                DesignPanel decodedPanel = (DesignPanel) decoder.readObject();
                decoder.close();
                fis.close();

                designPanel.removeAll();
                for (var component:decodedPanel.getComponents()) {
                    component.addFocusListener(new Focus(mainFrame, jTextArea));
                    designPanel.add(component);
                }
                mainFrame.repaint();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public String toString() {
        return "ControlPanel{" +
                "saveBtn=" + saveBtn +
                ", loadBtn=" + loadBtn +
                ", text=" + text +
                ", designPanel=" + designPanel +
                ", ui=" + ui +
                ", listenerList=" + listenerList +
                ", accessibleContext=" + accessibleContext +
                '}';
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}

package com.company;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO

        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //TODO
    }
    private void save(ActionEvent e) {
        try {

            ImageIO.write(frame.canvas.image, "PNG", new File("test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            BufferedImage image = ImageIO.read(new File("test.png"));
            frame.canvas.graphics.drawImage(image,null, 0,0);
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        Color color = new Color(255,255,255);
        frame.canvas.graphics.setColor(color);
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
    }

    private void exit(ActionEvent e) {
        frame.dispose();
    }


    //TODO
}
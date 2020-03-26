package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.Random;
import java.awt.Transparency;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
                ;
            }
        });
    }
    private void drawShape(int x, int y) {
        int radius = (Integer)frame.configPanel.sizeField.getValue();
        int sides = (Integer)frame.configPanel.sidesField.getValue();
        String culoare = frame.configPanel.colorCombo.getSelectedItem().toString();
        Color color;
        if(culoare.equals("Red")) {
             color = new Color(255, 0, 0);
        }
        else
        {
             color = new Color(0,0,255);
        }
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

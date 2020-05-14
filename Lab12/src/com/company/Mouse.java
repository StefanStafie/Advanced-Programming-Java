package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class Mouse implements MouseListener {
    DesignPanel designPanel;
    ControlPanel controlPanel;
    Point start;
    Point end;

    public Mouse(DesignPanel designPanel, ControlPanel controlPanel) {
        this.designPanel = designPanel;
        this.controlPanel = controlPanel;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        start = mouseEvent.getLocationOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        end = mouseEvent.getLocationOnScreen();

        String className = controlPanel.getText();
        try {
            Class clazz = Class.forName(className);
            JComponent object = (JComponent) clazz.getDeclaredConstructor().newInstance();
            object.addMouseListener(this);
            Random random = new Random();
            object.setBackground(Color.getHSBColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            object.setForeground(Color.getHSBColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            object.setIgnoreRepaint(false);
            object.setOpaque(true);
            object.setFocusable(true);
            object.setName("object " + className);
            object.setBounds(this.start.x, this.start.y-30,this.end.x - this.start.x, this.end.y - this.start.y);
            designPanel.add(object);
            designPanel.revalidate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Mouse implements MouseListener, Serializable {
    DesignPanel designPanel;
    ControlPanel controlPanel;
    MainFrame mainFrame;
    JFrame details;
    Point start;
    Point end;

    public Mouse(DesignPanel designPanel, ControlPanel controlPanel, MainFrame mainFrame, JFrame details) {
        this.designPanel = designPanel;
        this.controlPanel = controlPanel;
        this.mainFrame = mainFrame;
        this.details = details;
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

            object.addFocusListener(new Focus(mainFrame, details));
            Random random = new Random();
            object.setBackground(Color.getHSBColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            object.setForeground(Color.getHSBColor(random.nextFloat(), random.nextFloat(), random.nextFloat()));
            object.setIgnoreRepaint(false);
            object.setOpaque(true);
            object.setFocusable(true);
            object.setName("object " + className);
            object.setBounds(this.start.x, this.start.y - 30, this.end.x - this.start.x, this.end.y - this.start.y);

            designPanel.add(object);
            designPanel.revalidate();
            Method m = clazz.getMethod("setText", String.class);
            m.invoke(object, "text adaugat de mine");
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
        } catch (Exception e) {
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

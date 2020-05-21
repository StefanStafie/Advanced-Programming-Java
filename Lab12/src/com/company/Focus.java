package com.company;
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

public class Focus implements FocusListener, Serializable {
    MainFrame mainFrame;
    JTable details;


    public Focus(MainFrame mainFrame, JTable details) {
        this.mainFrame = mainFrame;
        this.details = details;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        try {
            BeanInfo info = Introspector.getBeanInfo(mainFrame.getFocusOwner().getClass());
            Vector<String> column = new Vector<>();
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                column.add(pd.getName());
            }
            details = new JTable(null, column);
            mainFrame.add(details);



        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        System.out.println("out");
    }
}

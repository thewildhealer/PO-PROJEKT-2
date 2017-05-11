package com.poprojekt2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class initWindow extends JFrame {
    private JButton button;
    private JPanel initPanel;
    private JTextField widthField;
    private JTextField heightField;

    public initWindow(Swiat swiat) {
        setContentPane(initPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button.addActionListener(but -> {
                int szerokosc = Integer.parseInt(widthField.getText());
                int wysokosc = Integer.parseInt(heightField.getText());
                swiat.setSzerokosc(szerokosc);
                swiat.setWysokosc(wysokosc);
                dispose();
                mainWindow w = new mainWindow(swiat);
        });
        setVisible(true);
    }
}

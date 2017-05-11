package com.poprojekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thewildhealer on 11.05.2017.
 */
public class initWindow extends JFrame {
    private JButton button;
    private JPanel initPanel;
    private JTextField widthField;
    private JTextField heightField;

    public initWindow(Swiat swiat) {
//setSize(500,500);
        setContentPane(initPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int szerokosc = Integer.parseInt(widthField.getText());
                int wysokosc = Integer.parseInt(heightField.getText());
                swiat.setSzerokosc(szerokosc);
                swiat.setWysokosc(wysokosc);
                dispose();
                mainWindow w = new mainWindow(swiat);
            }
        });
        setVisible(true);
    }
}

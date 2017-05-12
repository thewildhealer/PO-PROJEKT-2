package com.poprojekt2;

import javax.swing.*;
import java.awt.*;


public class InitWindow extends JFrame {
    private JButton button;
    private JPanel initPanel;
    private JTextField widthField;
    private JTextField heightField;

    public InitWindow(Swiat swiat) {
        setContentPane(initPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button.addActionListener(but -> {
            int szerokosc = Integer.parseInt(widthField.getText());
            int wysokosc = Integer.parseInt(heightField.getText());
            swiat.setSzerokosc(szerokosc);
            swiat.setWysokosc(wysokosc);
            dispose();
            MainWindow w = new MainWindow(swiat);
        });
        setVisible(true);
    }

}

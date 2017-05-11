package com.poprojekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class mainWindow extends JFrame {
    private JButton button1;
    private JPanel panelMain;
    private JPanel gamePanel;
    private Dimension mainDim;
    private Dimension gameDim;
    private int rectSize = 20;

    public mainWindow(Swiat swiat) {
        setContentPane(panelMain);
        mainDim = new Dimension(swiat.getSzerokosc() * rectSize + 50, swiat.getWysokosc() * rectSize + 50);
        gameDim = new Dimension(swiat.getSzerokosc() * rectSize, swiat.getWysokosc() * rectSize);
        panelMain.setPreferredSize(mainDim);
        gamePanel.setPreferredSize(gameDim);
        setResizable(false);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Random generator = new Random();
        button1.addActionListener(but -> {
                /*
                int x = (generator.nextInt(gamePanel.getWidth()/10) * rectSize);
                int y = (generator.nextInt(gamePanel.getHeight()/10) * rectSize);
                Graphics g = gamePanel.getGraphics();
                g.setColor(Color.MAGENTA);
                g.fillRect(x, y, rectSize, rectSize);
                g.setColor(Color.black);
                g.drawRect(x, y, rectSize, rectSize);
                g.dispose(); */
                generateGrid();
        });
        setVisible(true);
    }

    private void generateGrid() {
        int x = gamePanel.getWidth() / 10;
        int y = gamePanel.getHeight() / 10;
        Graphics g = gamePanel.getGraphics();
        g.setColor(Color.gray);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                g.drawRect(i * rectSize, j * rectSize, rectSize, rectSize);
            }
        }
        g.dispose();
    }

}

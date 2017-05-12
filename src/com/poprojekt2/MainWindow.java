package com.poprojekt2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame {
    private JButton button1;
    private JPanel panelMain;
    private JPanel gamePanel;
    private Swiat swiat;
    private int rectSize = 20;

    public MainWindow(Swiat swiat) {
        setContentPane(panelMain);
        this.swiat = swiat;
        Dimension mainDim = new Dimension(swiat.getSzerokosc() * rectSize + 50, swiat.getWysokosc() * rectSize + 50);
        Dimension gameDim = new Dimension(swiat.getSzerokosc() * rectSize, swiat.getWysokosc() * rectSize);
        panelMain.setPreferredSize(mainDim);
        gamePanel.setPreferredSize(gameDim);
        gamePanel.setMinimumSize(gameDim);
        gamePanel.setMaximumSize(gameDim);

        //gamePanel.add(new GamePanel(swiat, rectSize) );

        // setResizable(false);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Random generator = new Random();
        button1.addActionListener(but -> {
            swiat.wykonajTure();
            repaint();
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
    }

    private void paintField(int x, int y) {
        Graphics g = gamePanel.getGraphics();
        g.setColor(Color.black);
        g.fillRect(x * rectSize, y * rectSize, rectSize, rectSize);
    }

    private void clearAll() {
        Graphics g = gamePanel.getGraphics();
        int x = gamePanel.getWidth() / 10;
        int y = gamePanel.getHeight() / 10;
        g.setColor(Color.white);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                g.fillRect(i * rectSize, j * rectSize, rectSize, rectSize);
            }
        }

    }

    private void update(Swiat swiat) {
        int x = swiat.getSzerokosc();
        int y = swiat.getWysokosc();
        Graphics g = gamePanel.getGraphics();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (swiat.getRysunek(i, j) != null) {
                    g.setColor(swiat.getRysunek(i,j).getColor());
                    g.fillRect(i * rectSize, j * rectSize, rectSize, rectSize);
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        clearAll();
        update(swiat);
        generateGrid();
    }

}
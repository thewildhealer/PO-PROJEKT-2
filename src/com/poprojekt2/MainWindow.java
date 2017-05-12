package com.poprojekt2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainWindow extends JFrame {
    private JButton button1;
    private JPanel panelMain;
    private JPanel gamePanel;
    private int rectSize = 20;

    public MainWindow(Swiat swiat) {
        setContentPane(panelMain);

        Dimension mainDim = new Dimension(swiat.getSzerokosc() * rectSize + 50, swiat.getWysokosc() * rectSize + 50);
        Dimension gameDim = new Dimension(swiat.getSzerokosc() * rectSize, swiat.getWysokosc() * rectSize);
        panelMain.setPreferredSize(mainDim);
        gamePanel.setPreferredSize(gameDim);

        //gamePanel.add(new GamePanel(swiat, rectSize) );

        setResizable(false);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Random generator = new Random();
        button1.addActionListener(but -> {
            //           swiat.wykonajTure();
            //           update(swiat);
            paintField(0, 0);
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

    private void paintField(int x, int y) {
        Graphics g = gamePanel.getGraphics();
        g.setColor(Color.black);
        g.fillRect(x * rectSize, y * rectSize, rectSize, rectSize);
        g.dispose();
    }

    private void update(Swiat swiat) {
        int x = swiat.getSzerokosc();
        int y = swiat.getWysokosc();
        Graphics g = gamePanel.getGraphics();
        g.setColor(Color.black);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (swiat.getRysunek(i, j) != null)
                    g.fillRect(i * rectSize, j * rectSize, rectSize, rectSize);
            }
        }
        g.dispose();
    }

}

class GamePanel extends JPanel {
    //  Swiat swiat;
    int rectSize;
    Dimension gameDim;

    public GamePanel(Swiat swiat, int rectSize) {
        gameDim = new Dimension(swiat.getSzerokosc() * rectSize, swiat.getWysokosc() * rectSize);
        setPreferredSize(gameDim);
        this.rectSize = rectSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = this.getWidth() / 10;
        int y = this.getHeight() / 10;
        g2d.setColor(Color.gray);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                g2d.drawRect(i * rectSize, j * rectSize, rectSize, rectSize);
            }
        }

    }
}
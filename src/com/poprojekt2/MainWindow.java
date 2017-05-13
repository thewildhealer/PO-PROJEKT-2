package com.poprojekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class MainWindow extends JFrame implements ActionListener, KeyListener {
    private JButton button1;
    private JPanel panelMain;
    private JPanel gamePanel;
    private JTextArea comments;
    private JButton zapiszButton;
    private JButton wczytajButton;
    private JComboBox comboBox1;
    private JTabbedPane tabbedPane1;
    private JTextPane legenda;
    private Swiat swiat;
    private int rectSize = 20;
    Timer t = new Timer(5, this);

    public MainWindow(Swiat swiat) {
        super("Konrad Zawora 165115");
        setContentPane(panelMain);
        this.swiat = swiat;
        Dimension mainDim = new Dimension(swiat.getSzerokosc() * rectSize + 300, swiat.getWysokosc() * rectSize + 50);
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
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        button1.addActionListener(but -> {
            action();
        });
        setVisible(true);
    }

    private void generateGrid() {
        int x = gamePanel.getWidth() / 10;
        int y = gamePanel.getHeight() / 10;
        Graphics g = gamePanel.getGraphics();
        g.setColor(Color.lightGray);
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

    private void comment(Swiat swiat) {
        ArrayList<String> komentarze = swiat.komentuj();
        comments.setText("");
        for (String kom : komentarze)
            comments.append(kom + System.getProperty("line.separator"));
        swiat.czyscKomentarze();
    }

    private void update(Swiat swiat) {
        int x = swiat.getSzerokosc();
        int y = swiat.getWysokosc();
        Graphics g = gamePanel.getGraphics();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (swiat.getRysunek(i, j) != null) {
                    g.setColor(swiat.getRysunek(i, j).getColor());
                    g.fillRect(i * rectSize, j * rectSize, rectSize, rectSize);
                }
            }
        }
    }
    private void action() {
        swiat.wykonajTure();
        comment(swiat);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        clearAll();
        update(swiat);
        generateGrid();
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                action();
                break;
            case KeyEvent.VK_ENTER:
                action();
                break;
            case KeyEvent.VK_UP:
                swiat.setCzlowiekDirection('w');
                action();
                break;
            case KeyEvent.VK_DOWN:
                swiat.setCzlowiekDirection('s');
                action();
                break;
            case KeyEvent.VK_LEFT:
                swiat.setCzlowiekDirection('a');
                action();
                break;
            case KeyEvent.VK_RIGHT:
                swiat.setCzlowiekDirection('d');
                action();
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
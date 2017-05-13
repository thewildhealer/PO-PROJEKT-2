package com.poprojekt2;

import javax.swing.*;


public class InitWindow extends JFrame {
    private JButton button;
    private JPanel initPanel;
    private JTextField widthField;
    private JTextField heightField;

    public InitWindow() {
        setContentPane(initPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button.addActionListener(but -> {
            int szerokosc = Integer.parseInt(widthField.getText());
            int wysokosc = Integer.parseInt(heightField.getText());
            dispose();

            Swiat swiat = new Swiat(szerokosc, wysokosc);

            for (int i = 0; i < 2; i++) {

                swiat.dodajOrganizm(new Wilk(swiat));
                swiat.dodajOrganizm(new Owca(swiat));
                swiat.dodajOrganizm(new Zolw(swiat));
                swiat.dodajOrganizm(new Antylopa(swiat));
                swiat.dodajOrganizm(new Lis(swiat));

                swiat.dodajOrganizm(new Trawa(swiat));
                swiat.dodajOrganizm(new Mlecz(swiat));
                swiat.dodajOrganizm(new Guarana(swiat));
                swiat.dodajOrganizm(new WilczeJagody(swiat));
                swiat.dodajOrganizm(new BarszczSosnowskiego(swiat));
            }
            swiat.dodajOrganizm(new Czlowiek(swiat));
            MainWindow w = new MainWindow(swiat);
        });
        setVisible(true);
    }

}

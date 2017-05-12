package com.poprojekt2;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Swiat swiat = new Swiat(10, 10);
        swiat.dodajOrganizm(new Wilk(1, 0, swiat));
        swiat.dodajOrganizm(new Wilk(4, 5, swiat));

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainWindow(swiat);
            }
        });
    }
}

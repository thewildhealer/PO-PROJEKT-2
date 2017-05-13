package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Lis extends Zwierze {

    public Lis(Swiat swiat) {
        super(swiat);
        sila = 3;
        inicjatywa = 7;
    }

    public Lis(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 3;
        inicjatywa = 7;
    }

    public Color getColor() {
        return Color.red;
    }

    public void akcja() {
        prevX = x;
        prevY = y;
        int los;
        int count = 0;
        boolean test = true;
        while (test) {
            for (int i = 0; i < 4 && prevX == x && prevY == y; i++) {
                Random rand = new Random();
                los = rand.nextInt(4);
                if (los == 0) x += mod;
                else if (los == 1) x -= mod;
                else if (los == 2) y += mod;
                else if (los == 3) y -= mod;

                while (x < 0) x++;
                while (y < 0) y++;
                while (y > swiat.getWysokosc() - 1) y--;
                while (x > swiat.getSzerokosc() - 1) x--;
            }

            if (swiat.getRysunek(x, y) != null && swiat.getRysunek(x, y) != this && swiat.getRysunek(x, y).getSila() <= sila) {
                test = false;
            }
            if (swiat.getRysunek(x, y) != null && swiat.getRysunek(x, y) != this && swiat.getRysunek(x, y).getSila() > sila) {
                x = prevX;
                y = prevY;
                test = true;
            }
            if (swiat.getRysunek(x, y) == null) {
                test = false;
            }
            if (count >= 10) {
                x = prevX;
                y = prevY;
                test = false;
            }
            count++;
        }

        if (x == prevX && y == prevY) return;
        if (swiat.getRysunek(x, y) == null) {
            swiat.setRysunek(x, y, this);
            swiat.setRysunek(prevX, prevY, null);
        } else swiat.getRysunek(x, y).kolizja(this);
    }

    public void kopuluj(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Lis(x, y, swiat));
    }

    public String getNazwa() {
        return "Lis";
    }
}

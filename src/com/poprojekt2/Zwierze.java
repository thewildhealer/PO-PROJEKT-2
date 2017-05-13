package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
abstract public class Zwierze extends Organizm {
    protected boolean newBorn;
    protected int mod;

    public Zwierze(Swiat swiat) {
        super(swiat);
        this.newBorn = true;
        mod = 1;
    //    swiat.setBreakFlag(true);
    }

    public Zwierze(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        newBorn = true;
        mod = 1;
    //    swiat.setBreakFlag(true);

    }

    public Color getColor() {
        return Color.green;
    }

    public void akcja() {
        prevX = x;
        prevY = y;
        int los;
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
        if (x == prevX && y == prevY) return;
        if (swiat.getRysunek(x, y) == null) {
            swiat.setRysunek(x, y, this);
            swiat.setRysunek(prevX, prevY, null);
        } else swiat.getRysunek(x, y).kolizja(this);

        if (newBorn) newBorn = false;
    }
    public void kolizja(Organizm napastnik) {
        if (napastnik.getColor() == this.getColor()) {
            if(this.getNewBorn() || napastnik.getNewBorn()) {
                napastnik.setX(napastnik.getPrevX());
                napastnik.setY(napastnik.getPrevY());
                return;
            }
            int count = 0;
            Random rand = new Random();
            int los = rand.nextInt(10);
            int i = 0, j = 0;
            if (los != 0) {
                while (count < 5 && swiat.getRysunek(x + i, y + j) != null &&
                        x + i < swiat.getSzerokosc() - 1 && x + i > 0 &&
                        y + j < swiat.getWysokosc() - 1 && y + j > 0) {

                    i = rand.nextInt(3) - 1;
                    j = rand.nextInt(3) - 1;
                    count++;
                }
                ;
            }

            if (swiat.getRysunek(x + i, y + j) == null) {
                swiat.narodziny(this, x + i, y + j);
                this.kopuluj(x + i, y + j);
            }
            napastnik.setX(napastnik.getPrevX());
            napastnik.setY(napastnik.getPrevY());
        } else {
            if (napastnik.getSila() >= this.sila) {
                swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
                swiat.umrzyj(napastnik, this);
            }
            if (napastnik.getSila() < this.sila) {
                swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
                swiat.umrzyj(this, napastnik);
            }

        }
    }
    abstract public void kopuluj(int x, int y);

    public String getNazwa() {
        return "Wilk";
    }
}

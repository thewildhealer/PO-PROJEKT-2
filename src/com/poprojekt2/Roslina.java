
package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
abstract public class Roslina extends Organizm {
    private boolean nowoZasiana;

    public Roslina(Swiat swiat) {
        super(swiat);
        prevX = x;
        prevY = y;
        nowoZasiana = true;
        inicjatywa = 0;
        sila = 0;
    }

    public Roslina(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        prevX = x;
        prevY = y;
        nowoZasiana = true;
        inicjatywa = 0;
        sila = 0;
    }

    public Color getColor() {
        return Color.green;
    }

    public void akcja() {

        if (!nowoZasiana) {
            int count = 0;
            Random rand = new Random();
            int los = rand.nextInt(10);
            int i = 0, j = 0;
            if (los == 0) {
                while (count < 5 && swiat.getRysunek(x + i, y + j) != null &&
                        x + i < swiat.getSzerokosc() - 1 && x + i > 0 &&
                        y + j < swiat.getWysokosc() - 1 && y + j > 0) {

                    i = (rand.nextInt(3)) - 1;
                    j = (rand.nextInt(3)) - 1;
                    count++;
                };

                if (swiat.getRysunek(x + i, y + j) == null) {
                    swiat.nowaRoslina(this, x + i, y + j);
                    this.zasiej(x + i, y + j);
                }
            }
        }
        else nowoZasiana = false;
    }

    public void kolizja(Organizm napastnik) {
        if (napastnik.getSila() >= this.sila) {
            swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
            swiat.umrzyj(napastnik, this);
        }
        if (napastnik.getSila() < this.sila) {
            swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
            swiat.umrzyj(napastnik, this);
            swiat.umrzyj(this, napastnik);
            swiat.setRysunek(napastnik.getX(), napastnik.getY(), null);
        }
    }

    abstract public void zasiej(int x, int y);

    public String getNazwa() {
        return "Wilk";
    }
}

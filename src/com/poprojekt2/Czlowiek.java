package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Czlowiek extends Zwierze {
    private int licznik;
    private int cooldown;
    private int czasTrwania;
    private boolean umiejetnoscWlaczona;

//    private void calopalenie();

    public Czlowiek(Swiat swiat) {
        super(swiat);
        sila = 5;
        inicjatywa = 4;
        licznik = 5;
        cooldown = 5;
        umiejetnoscWlaczona = false;
        czasTrwania = 0;
        swiat.setCzlowiek(this);
    }

    public Czlowiek(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 5;
        inicjatywa = 4;
        licznik = 5;
        cooldown = 5;
        umiejetnoscWlaczona = false;
        czasTrwania = 0;
        swiat.setCzlowiek(this);
    }

    public Color getColor() {
        return Color.black;
    }

    public void kopuluj(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Czlowiek(x, y, swiat));
    }

    public void setDirection(char c) {
        prevX = x;
        prevY = y;
        switch (c) {
            case 'w':
                y--;
                break;
            case 's':
                y++;
                break;
            case 'a':
                x--;
                break;
            case 'd':
                x++;
                break;
        }
        while (x < 0) x++;
        while (y < 0) y++;
        while (y > swiat.getWysokosc() - 1) y--;
        while (x > swiat.getSzerokosc() - 1) x--;
    }

    public void akcja() {
   //     swiat.aktualizujRysunek();
        if (czasTrwania >= 5) {
            czasTrwania = 0;
            umiejetnoscWlaczona = false;
        }
        if (!umiejetnoscWlaczona && cooldown > licznik) licznik++;
/*
        else if (zn1 == 'q' && licznik == 5) {
            licznik = 0;
            umiejetnoscWlaczona = true;
        }
        else if (zn1 == 'z') swiat.zapiszSwiat();
        else if (zn1 == 'x') swiat.otworzSwiat();
*/

        if (x == prevX && y == prevY) return;
        if (swiat.getRysunek(x, y) == null) {
            swiat.setRysunek(x, y, this);
            swiat.setRysunek(prevX, prevY, null);
        }
        if (umiejetnoscWlaczona) {
  //          calopalenie();
            czasTrwania++;
        }
        else if (swiat.getRysunek(x, y) != this) swiat.getRysunek(x, y).kolizja(this);
    }

    public void kolizja(Organizm napastnik) {
        if (napastnik.getSila() >= this.sila) {
            swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
            swiat.umrzyj(napastnik, this);
        }
        if (napastnik.getSila() < this.sila) {
            swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
            swiat.umrzyj(this, napastnik);
        }
    }


    public String getNazwa() {
        return "Czlowiek";
    }
}

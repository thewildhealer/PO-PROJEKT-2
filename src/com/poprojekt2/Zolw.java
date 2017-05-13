package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Zolw extends Zwierze {
    private boolean newBorn;

    public Zolw(Swiat swiat) {
        super(swiat);
        sila = 2;
        inicjatywa = 1;
        //    swiat.setBreakFlag(true);
    }

    public Zolw(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 2;
        inicjatywa = 1;
        //    swiat.setBreakFlag(true);
    }

    public Color getColor() {
        return Color.lightGray;
    }

    public void akcja() {
        Random rand = new Random();
        int los = rand.nextInt(4);
        if (los == 0) super.akcja();
    }

    public void kolizja(Organizm napastnik) {
        if (napastnik.getSila() < 5 && napastnik.getColor() != this.getColor()) {
            napastnik.setX(getPrevX());
            napastnik.setY(getPrevY());
            swiat.nieudanyAtak(napastnik, this);
        }
        else super.kolizja(napastnik);
    }


    void kopuluj(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Zolw(x, y, swiat));
    }

    public String getNazwa() {
        return "Zolw";
    }
}

package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Antylopa extends Zwierze {
    private boolean newBorn;

    public Antylopa(Swiat swiat) {
        super(swiat);
        sila = 4;
        inicjatywa = 4;
        mod = 2;
        //    swiat.setBreakFlag(true);
    }

    public Antylopa(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 4;
        inicjatywa = 4;
        mod = 2;
        //    swiat.setBreakFlag(true);
    }

    public Color getColor() {
        return Color.orange;
    }

    public void kolizja(Organizm napastnik) {
        Random rand = new Random();
        int los = rand.nextInt(2);
        if (los == 0 && napastnik.getColor() != this.getColor()) {
            super.akcja();
            swiat.nieudanyAtak(napastnik, this);
        } else super.kolizja(napastnik);
    }

    void kopuluj(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Antylopa(x, y, swiat));
    }

    public String getNazwa() {
        return "Antylopa";
    }
}

package com.poprojekt2;

import java.awt.*;
import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Wilk extends Zwierze {
    private boolean newBorn;

    public Wilk(Swiat swiat) {
        super(swiat);
        sila = 9;
        inicjatywa = 5;
    //    swiat.setBreakFlag(true);
    }

    public Wilk(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 9;
        inicjatywa = 5;
    //    swiat.setBreakFlag(true);
    }

    public Color getColor() {
        return Color.blue;
    }

    void kopuluj(int x, int y) {
        if(!newBorn) swiat.dodajOrganizm(new Wilk(x, y, swiat));
    }

    public String getNazwa() {
        return "Wilk";
    }
}

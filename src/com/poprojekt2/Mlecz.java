package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Mlecz extends Roslina {

    public Mlecz(Swiat swiat) {
        super(swiat);
    }

    public Mlecz(int x, int y, Swiat swiat) {super(x, y, swiat);}

    public Color getColor() {
        return Color.yellow;
    }

    public void akcja() {
        for (int i = 0; i < 3; i++)
            super.akcja();
    }

    public void zasiej(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Mlecz(x, y, swiat));
    }

    public String getNazwa() {
        return "Mlecz";
    }
}

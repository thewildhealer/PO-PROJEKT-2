package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Trawa extends Roslina {

    public Trawa(Swiat swiat) {
        super(swiat);
    }

    public Trawa(int x, int y, Swiat swiat) {
        super(x, y, swiat);
    }

    public Color getColor() {
        return Color.green;
    }

    public void zasiej(int x, int y) {
        if (!newBorn) swiat.dodajOrganizm(new Trawa(x, y, swiat));
    }

    public String getNazwa() {
        return "Trawa";
    }
}

package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class WilczeJagody extends Roslina {

    public WilczeJagody(Swiat swiat) {
        super(swiat);
        sila = 99;
    }

    public WilczeJagody(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 99;
    }

    public Color getColor() {
        return Color.cyan;
    }

    public void zasiej(int x, int y) {
        if (!nowoZasiana) swiat.dodajOrganizm(new WilczeJagody(x, y, swiat));
    }

    public String getNazwa() {
        return "Wilcza jagoda";
    }
}

package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class BarszczSosnowskiego extends Roslina {

    public BarszczSosnowskiego(Swiat swiat) {
        super(swiat);
        sila = 10;
    }

    public BarszczSosnowskiego(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 10;
    }

    public Color getColor() {
        return Color.darkGray;
    }

    public void akcja() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++)
                if (x + i >= 0 && y + j >= 0 && x + i <= swiat.getSzerokosc() - 1 && y + j <= swiat.getWysokosc() - 1 &&
                        swiat.getRysunek(x + i, y + j) != null && swiat.getRysunek(x + i, y + j).getType() != 'r'){
                swiat.umrzyj(this, swiat.getRysunek(x + i, y + j));
            }
        }
        super.akcja();
    }

    public void zasiej(int x, int y) {
        if (!nowoZasiana) swiat.dodajOrganizm(new BarszczSosnowskiego(x, y, swiat));
    }

    public String getNazwa() {
        return "Barszcz sosnowskiego";
    }
}

package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Owca extends Zwierze {
    private boolean newBorn;

    public Owca(Swiat swiat) {
        super(swiat);
        sila = 4;
        inicjatywa = 4;
    //    swiat.setBreakFlag(true);
    }

    public Owca(int x, int y, Swiat swiat) {
        super(x, y, swiat);
        sila = 4;
        inicjatywa = 4;
    //    swiat.setBreakFlag(true);
    }

    public Color getColor() {
        return Color.gray;
    }

    void kopuluj(int x, int y) {
        if(!newBorn) swiat.dodajOrganizm(new Owca(x, y, swiat));
    }

    public String getNazwa() {
        return "Owca";
    }
}

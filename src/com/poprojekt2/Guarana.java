package com.poprojekt2;

import java.awt.*;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Guarana extends Roslina {

    public Guarana(Swiat swiat) {
        super(swiat);
    }

    public Guarana(int x, int y, Swiat swiat) {super(x, y, swiat);}

    public Color getColor() {
        return Color.pink;
    }

    public void kolizja(Organizm napastnik) {
        swiat.umrzyj(napastnik, this);
        napastnik.setSila(napastnik.getSila() + 3);
        swiat.setRysunek(x, y, napastnik);
        swiat.setRysunek(napastnik.getPrevX(), napastnik.getPrevY(), null);
    }

    public void zasiej(int x, int y) {
        if (!nowoZasiana) swiat.dodajOrganizm(new Guarana(x, y, swiat));
    }

    public String getNazwa() {
        return "Guarana";
    }
}

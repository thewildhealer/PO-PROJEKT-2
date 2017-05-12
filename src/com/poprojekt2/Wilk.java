package com.poprojekt2;

import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
public class Wilk extends Organizm {
    public Wilk(Swiat swiat) {
        super(swiat);
    }
    public Wilk(int x, int y, Swiat swiat) {
        super(x,y,swiat);
    }

    public void akcja() {
        prevX = x;
        prevY = y;
        int los;
        for (int i = 0; i < 4 && prevX == x && prevY == y; i++) {
            Random rand = new Random();
            los = rand.nextInt(4);
            if (los == 0) x += 1;
            else if (los == 1) x -= 1;
            else if (los == 2) y += 1;
            else if (los == 3) y -= 1;

            while (x < 0) x++;
            while (y < 0) y++;
            while (y > swiat.getWysokosc() - 1) y--;
            while (x > swiat.getSzerokosc() - 1) x--;
        }
        if (x == prevX && y == prevY) return;
        if (swiat.getRysunek(x, y) == null) {
            swiat.setRysunek(x, y, this);
            swiat.setRysunek(prevX, prevY, null);
        }
       // else swiat.getRysunek(x, y)->kolizja(this);

    }
}

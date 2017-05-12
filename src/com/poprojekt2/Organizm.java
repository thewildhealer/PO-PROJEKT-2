package com.poprojekt2;

import java.util.Random;

/**
 * Created by thewildhealer on 12.05.2017.
 */
abstract public class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int x, y;
    protected int prevX, prevY;
    protected Swiat swiat;

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public Organizm(Swiat swiat) {
        do {
            Random generator = new Random();
            x = generator.nextInt() % swiat.getSzerokosc();
            y = generator.nextInt() % swiat.getWysokosc();
        }
        while (swiat.getRysunek(x, y) != null);
        swiat.setRysunek(x, y, this);
    }

    public Organizm(int x, int y, Swiat swiat) {
        if (swiat.getRysunek(x, y) == null)
            swiat.setRysunek(x, y, this);
    }

    abstract public void akcja();

}

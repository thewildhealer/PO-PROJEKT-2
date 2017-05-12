package com.poprojekt2;

import java.util.ArrayList;

public class Swiat {
    private int wysokosc, szerokosc;
    private boolean breakFlag;
    private ArrayList<Organizm> organizmy;
    private Organizm[] rysunek;


    public Swiat() {
        breakFlag = false;
        inicjalizujRysunek();
    }

    public Swiat(int x, int y) {
        this.szerokosc = x;
        this.wysokosc = y;
        breakFlag = false;
        inicjalizujRysunek();
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(int w) {
        this.wysokosc = w;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(int s) {
        this.szerokosc = s;
    }

    public void dodajOrganizm(Organizm organizm) {

        // TODO: naprawic sortowanie
        organizmy.add(organizm); /*
        if (organizmy.size() > 1) {
            int i = organizmy.size() - 1;
            while (organizmy.toArray()[i - 1].getInicjatywa() < organizmy.toArray()[i].getInicjatywa()) {
  //              swap(organizmy[i - 1], organizmy[i]);
                if (i > 1) i--;
                else break;
            }
        }
        */
    }

    public void umrzyj(Organizm napastnik, Organizm ofiara) {

    }

    public void narodziny(Organizm org, int x, int y) {

    }

    public void nieudanyAtak(Organizm napastnik, Organizm ofiara) {

    }

    public void umiejetnoscAktywowana(Organizm org, int czasTrwania) {

    }

    public void otworzSwiat() {

    }

    public void zapiszSwiat() {

    }

    public void aktualizujRysunek() {

    }

    public void inicjalizujRysunek() {
        organizmy = new ArrayList<Organizm>();
        rysunek = new Organizm[szerokosc * wysokosc];
        for (int i = 0; i < szerokosc * wysokosc; i++)
            rysunek[i] = null;
    }

    public void wykonajTure() {

        for (int i = 0; i < organizmy.size(); i++) {
            if (!breakFlag) organizmy.get(i).akcja();
        }
        if (breakFlag) breakFlag = false;

        aktualizujRysunek();
    }

    public void rysujSwiat() {
        for (int i = 0; i < szerokosc * wysokosc; i++)
            rysunek[i] = null;
        for (Organizm org : organizmy)
            setRysunek(org.getX(), org.getY(), org);
    }

    public void setRysunek(int x, int y, Organizm org) {
        rysunek[x + y * szerokosc] = org;
    }

    Organizm getRysunek(int x, int y) {
        return rysunek[x + y * szerokosc];
    }


}

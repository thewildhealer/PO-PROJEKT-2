package com.poprojekt2;

import java.util.ArrayList;
import java.util.Collections;

public class Swiat {
    private int wysokosc, szerokosc;
    private boolean breakFlag;
    private ArrayList<Organizm> organizmy;
    private Organizm[] rysunek;
    private Komentator komentator;
    private Czlowiek czlowiek;


    public Swiat(int x, int y) {
        komentator = new Komentator();
        this.szerokosc = x;
        this.wysokosc = y;
        breakFlag = false;
        inicjalizujRysunek();
    }

    public int getWysokosc() {
        return wysokosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public void setBreakFlag(boolean breakFlag) {
        this.breakFlag = breakFlag;
    }

    public void dodajOrganizm(Organizm organizm) {

        organizmy.add(organizm);
        if (organizmy.size() > 1) {
            int i = organizmy.size() - 1;
            while (organizmy.get(i - 1).getInicjatywa() < organizmy.get(i).getInicjatywa()) {
                Collections.swap(organizmy, i - 1, i);
                if (i > 1) i--;
                else break;
            }
        }

    }

    public ArrayList<String> komentuj() {
        return komentator.komentujTure();
    }

    public void czyscKomentarze() {
        komentator.wyczyscKomentarze();
    }

    public void umrzyj(Organizm napastnik, Organizm ofiara) {
        komentator.komentujSmierc(napastnik, ofiara);
        setRysunek(ofiara.getX(), ofiara.getY(), null);
        setRysunek(napastnik.getX(), napastnik.getY(), napastnik);
        //  organizmy.erase(std::remove(organizmy.begin(), organizmy.end(), ofiara), organizmy.end());
        organizmy.remove(ofiara);
        //       ofiara = null;
    }

    public void narodziny(Organizm org, int x, int y) {
        komentator.komentujNarodziny(org, x, y);
    }

    public void nieudanyAtak(Organizm napastnik, Organizm ofiara) {
        komentator.komentujNieudanyAtak(napastnik, ofiara);
    }

    public void nowaRoslina(Organizm org, int x, int y) {
        komentator.komentujNowaRoslina(org, x, y);
    }

    public void umiejetnoscAktywowana(Organizm org, int czasTrwania) {
        komentator.komentujUmiejetnosc(org, czasTrwania);
    }

    public void otworzSwiat() {

    }

    public void zapiszSwiat() {

    }

    public void aktualizujRysunek() {
        for (int i = 0; i < szerokosc * wysokosc; i++)
            rysunek[i] = null;
        for (Organizm org : organizmy)
            setRysunek(org.getX(), org.getY(), org);

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

    public void setCzlowiek(Czlowiek czlowiek) {
        this.czlowiek = czlowiek;
    }

    public void setCzlowiekDirection(char c) {
        if (czlowiek != null) czlowiek.setDirection(c);
    }

    public void setRysunek(int x, int y, Organizm org) {
        rysunek[x + y * szerokosc] = org;
    }

    Organizm getRysunek(int x, int y) {
        return rysunek[x + y * szerokosc];
    }

}

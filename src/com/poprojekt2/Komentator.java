package com.poprojekt2;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by thewildhealer on 13.05.2017.
 */
public class Komentator {
private ArrayList<String> komentarze;
    public Komentator() {
        komentarze = new ArrayList<String>();
    }

    public ArrayList<String> komentujTure() {
        return komentarze;
    }

    public void komentujSmierc(Organizm napastnik, Organizm ofiara) {
        String pos = "[" + ofiara.getX() + "," + ofiara.getY() + "] ";
        String komentarz = napastnik.getNazwa() + " anihiluje: " + ofiara.getNazwa();
        komentarze.add(pos + komentarz);
    }


    public void komentujNarodziny(Organizm org, int x, int y) {
        String pos = "[" + x + "," + y + "] ";
        String komentarz = "Narodzil/a sie nowy/a " + org.getNazwa() + "!";
        komentarze.add(pos + komentarz);
    }

    public void komentujNowaRoslina(Organizm org, int x, int y) {
        String pos = "[" + x + "," + y + "] ";
        String komentarz = "Urosla nowa roslina: " + org.getNazwa() + "!";
        komentarze.add(pos + komentarz);
    }


    public void komentujNieudanyAtak(Organizm napastnik, Organizm ofiara) {
        String pos = "[" + ofiara.getX() + "," + ofiara.getY() + "] ";
        String komentarz = ofiara.getNazwa() + " odparl/a atak od: " + napastnik.getNazwa() + "!";
        komentarze.add(pos + komentarz);
    }


    public void komentujUmiejetnosc(Organizm org, int czasTrwania) {
        String pos = "[" + org.getX() + "," + org.getY() + "] ";
        String komentarz = org.getNazwa() + " wlaczyl calopalenie! Bedzie trwac jeszcze przez " + (5 - czasTrwania) + " tury.";
        komentarze.add(pos + komentarz);
    }


    public void wyczyscKomentarze() {
        komentarze.clear();
    }

}

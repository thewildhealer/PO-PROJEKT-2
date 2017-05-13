package com.poprojekt2;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

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
        for (int i = szerokosc * wysokosc - 1; i >= 0; i--)
            rysunek[i] = null;
        organizmy.clear();

        Path path = Paths.get("save.sav");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> {
                String[] save = s.split("\\s+");
                int x = Integer.parseInt(save[1]);
                int y = Integer.parseInt(save[2]);
                int prevX = Integer.parseInt(save[3]);
                int prevY = Integer.parseInt(save[4]);
                int sila = Integer.parseInt(save[5]);
                try {
                    Class<?> klasa = Class.forName(save[0]);
                    Constructor<?> ctor = klasa.getConstructor(int.class, int.class, Swiat.class);
                    Object object = ctor.newInstance(x, y, this);

                    dodajOrganizm((Organizm) object);

                    ((Organizm) object).setPrevX(prevX);
                    ((Organizm) object).setPrevY(prevY);
                    ((Organizm) object).setSila(sila);

                    if (save.length == 7) {
                    int czasTrwania = Integer.parseInt(save[6]);
                    ((Czlowiek) object).setCzasTrwania(czasTrwania);
                    }

                } catch (InvocationTargetException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InstantiationException ex) {
                }
            });
        } catch (IOException ex) {
        }

    }

    public void zapiszSwiat() {
        try {
            PrintWriter out = new PrintWriter("save.sav", "UTF-8");
            String orgSave;
            for (Organizm org : organizmy) {
                if (org == czlowiek) {
                    orgSave = czlowiek.getClass().getName() + " " + czlowiek.getX() + " " + czlowiek.getY() + " " + czlowiek.getPrevX() + " " + czlowiek.getPrevY() + " " + czlowiek.getSila() + " " + czlowiek.getCzasTrwania();
                } else {
                    orgSave = org.getClass().getName() + " " + org.getX() + " " + org.getY() + " " + org.getPrevX() + " " + org.getPrevY() + " " + org.getSila();

                }
                out.println(orgSave);
            }
            out.close();
        } catch (IOException e) {
        }
    }

    public void aktualizujRysunek() {
        for (int i = szerokosc * wysokosc - 1; i >= 0; i--)
            rysunek[i] = null;
        for (int i = organizmy.size() - 1; i >= 0; i--)
            setRysunek(organizmy.get(i).getX(), organizmy.get(i).getY(), organizmy.get(i));
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

    public void setCzlowiekFlag(boolean f) {
        if (czlowiek.getLicznik() == 5)
            czlowiek.setFlag(f);
    }

    public void setRysunek(int x, int y, Organizm org) {
        rysunek[x + y * szerokosc] = org;
    }

    Organizm getRysunek(int x, int y) {
        return rysunek[x + y * szerokosc];
    }

}

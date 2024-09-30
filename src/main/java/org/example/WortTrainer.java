package org.example;

import java.util.Random;

/**
 * Diese Klasse kann ein zufälliges WortListe-Objekt ausgeben
 * oder checken, ob es mit einem anderen Wort übereinstimmt.
 * @author Manuel Durst
 * @version 2022-09-11
 */
public class WortTrainer {
    private WortListe objekt;
    private String wort;
    //statistik
    private int abfrage;
    private int richtig;
    /**
     * Dies ist der Konstruktor
     * @param objekt ist das übergebene Wortliste Objekt
     */
    public WortTrainer(WortListe objekt) {
        try {
            this.objekt = objekt;
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }

    }

    public WortListe getWortListe(){
        return this.objekt;
    }
    /**
     * Diese Methode WortZufall gibt einen zufälligen
     * Eintrag von dem aktuellen Wortliste-Objekt aus
     * @return gibt das zufällige Wort zurück
     */
    public WortEintrag WortZufall(){
        Random r = new Random();
        int randomNum = r.nextInt(objekt.getWorteinträge().length);
        WortEintrag randomEintrag = objekt.getWorteinträge()[randomNum];
        this.wort = randomEintrag.getWort();
        return randomEintrag;
    }

    /**
     * Diese Methode WortAktuell gibt das Wort
     * des aktuellen Worteintrages zurück
     * @return gibt das aktuelle Wort zurück
     */
    public String WortAktuell(){
        this.abfrage++;
        return this.wort;
    }

    /**
     * Diese Methode check vergleicht ein eingegebenes
     * Wort mit dem aktuellen Worteintrag.
     * @param wort1 ist das eingegebene Wort
     * @return gibt zurück, ob die Wörter übereinstimmen
     */
    public boolean check (String wort1){ //todo Wortaktuell einbauen
        if(wort1.equals(this.wort)){
            this.richtig++;
            return true;
        }
        return false;
    }

    /**
     * Diese Methode check vergleicht ein eingegebenes
     * Wort mit dem aktuellen Worteintrag. Groß- und
     * Kleinschreibung wird dabei nicht beachtet.
     * @param wort1 ist das eingegebene Wort
     * @return gibt zurück, ob die Wörter übereinstimmen
     */
    public boolean checkIgnoreCase (String wort1){ //todo Wortaktuell einbauen
        this.abfrage ++;
        if(wort1.toUpperCase().equals(this.wort.toUpperCase())){
            this.richtig++;
            return true;
        }
        return false;
    }

    public int getAbfrage(){
        return this.abfrage;
    }
    public int getRichtig(){
        return this.richtig;
    }

    public void abfrageUp(){
        this.abfrage = abfrage + 1;
    }
    public void richtigUp(){
        this.richtig = richtig + 1;
    }
    public void zuruecksetzen(){
        this.abfrage = 0;
        this.richtig = 0;
    }
    public String AbfrageRichtigToString(){
        String text = "Von " + this.abfrage + " Abfrage(n) waren " + this.richtig + " richtig.";
        return text;
    }
}

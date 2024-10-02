package org.example;

import java.util.Random;

public class WortTrainer {
    private WortListe objekt;
    private String wort;  // Das aktuelle zu ratende Wort
    private int abfrage;  // Anzahl der Abfragen
    private int richtig;  // Anzahl der richtigen Antworten

    public WortTrainer(WortListe objekt) {
        if (objekt == null || objekt.getWortEinträge().isEmpty()) {
            throw new IllegalArgumentException("Die Wortliste darf nicht null oder leer sein.");
        }
        this.objekt = objekt;
        this.wort = null;  // Anfangs ist kein Wort ausgewählt
    }

    // Setter für aktuelles Wort, Abfrage und Richtig
    public void setAktuellesWort(String wort) {
        this.wort = wort;
    }

    public void setAbfrage(int abfrage) {
        this.abfrage = abfrage;
    }

    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }

    /**
     * Diese Methode check vergleicht ein eingegebenes
     * Wort mit dem aktuellen Worteintrag.
     * @param wort1 ist das eingegebene Wort
     * @return gibt zurück, ob die Wörter übereinstimmen
     */
    public boolean check(String wort1) {
        if (this.wort == null) {
            throw new IllegalStateException("Es wurde noch kein Wort ausgewählt");
        }

        this.abfrage++;  // Anzahl der Abfragen erhöhen
        if (wort1.equals(this.wort)) {
            this.richtig++;  // Anzahl der richtigen Antworten erhöhen
            this.wort = null;  // Wort zurücksetzen, da es richtig geraten wurde
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
    public boolean checkIgnoreCase(String wort1) {
        if (this.wort == null) {
            throw new IllegalStateException("Es wurde noch kein Wort ausgewählt");
        }

        this.abfrage++;  // Anzahl der Abfragen erhöhen
        if (wort1.equalsIgnoreCase(this.wort)) {
            this.richtig++;  // Anzahl der richtigen Antworten erhöhen
            this.wort = null;  // Wort zurücksetzen, da es richtig geraten wurde
            return true;
        }
        return false;
    }

    public WortEintrag wortZufall() {
        Random r = new Random();
        int randomNum = r.nextInt(objekt.getWortEinträge().size());
        WortEintrag randomEintrag = objekt.getWortEinträge().get(randomNum);
        this.wort = randomEintrag.getWort();  // Das aktuelle Wort wird gesetzt
        return randomEintrag;
    }

    public String wortAktuell() {
        if (this.wort == null) {
            throw new IllegalStateException("Es wurde noch kein Wort ausgewählt");
        }
        return this.wort;
    }

    public WortListe getWortListe() {
        return this.objekt;
    }

    public int getAbfrage() {
        return abfrage;
    }

    public int getRichtig() {
        return richtig;
    }

    public void zuruecksetzen() {
        this.abfrage = 0;
        this.richtig = 0;
    }

    /**
     * Diese Methode gibt eine String-Darstellung der Statistik zurück.
     * @return eine Beschreibung der Anzahl der Abfragen und richtigen Antworten
     */
    public String abfrageRichtigToString() {
        return "Von " + this.abfrage + " Abfrage(n) waren " + this.richtig + " richtig.";
    }

}

package org.example;

/**
 * Diese Klasse erstellt eine Wortliste, wo man mehrere
 * Wörter eintragen und löschen kann.
 * @author Manuel Durst
 * @version 2022-09-11
 */
public class WortListe {
    private WortEintrag[] Worteinträge = new WortEintrag[0];

    /**
     * Diese Methode fügt Wörter zu der Wortliste
     * hinzu und vergrößert diese dabei.
     * @param wort ist das Wort, das hinzugefügt werden soll
     */
    public void addWort(WortEintrag wort){  //todo ändern
        try {
                WortEintrag[] temp = new WortEintrag[this.Worteinträge.length + 1];
                for (int i = 0; i < Worteinträge.length; i++) {
                    temp[i] = Worteinträge[i];
                }
                temp[temp.length - 1] = wort;
                Worteinträge = temp;
        }catch (NullPointerException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Doese Methode gibt den Worteintrag des
     * eingegebenen Indexes zurück.
     * @param index ist der eingegebene Index
     * @return gibt den Worteintrag zurück
     */
    public WortEintrag getWorteinträge(int index) {
        try {
            return Worteinträge[index];
        }catch (IndexOutOfBoundsException | NullPointerException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Diese Methode sucht die eingegebene
     * Bezeichnung und löscht dieses von den Worteinträgen.
     * @param Bezeichnung ist die eingegebene Bezeichnung
     * @return gibt zurück, ob die Bezeichnung erfolgreich gelöscht werden konnte
     */
    public boolean loeschWort(String Bezeichnung){
        try {
            boolean wahr = false;
            for (int i = 0; i < this.Worteinträge.length; i++) {
                if (Bezeichnung.equals(this.Worteinträge[i].getWort())) {
                    this.Worteinträge[i] = null;
                    wahr = true;
                }
            }
            boolean geloescht = false;
            WortEintrag[] temp = new WortEintrag[Worteinträge.length-1];
            for(int i = 0, y = 0; y < temp.length; i++) {
                if(Worteinträge[i] != null){
                    temp[y] = Worteinträge[i];
                    y++;
                }
            }
            this.Worteinträge = temp;
            return wahr;
        }catch(NullPointerException e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    /**
     * Diese Methode ändert die Methode toString der Superklasse.
     * Es werden die Daten zu einem text zusammengefasst
     * @return gibt den erstellten Text zurück
     */
    @Override
    public String toString(){
        String text = "";
        for(int i = 0; i < Worteinträge.length; i++){
            text = text + Worteinträge[i].getWort() + " " + Worteinträge[i].getURL() + "\n";
        }
        return text;
    }
}

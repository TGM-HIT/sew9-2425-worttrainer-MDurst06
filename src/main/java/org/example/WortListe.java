package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse erstellt eine Wortliste, wo man mehrere
 * Wörter eintragen und löschen kann.
 * @author Manuel Durst
 * @version 02-10-2024
 */
public class WortListe {
    private List<WortEintrag> wortEinträge;

    public WortListe() {
        this.wortEinträge = new ArrayList<>();
    }

    public List<WortEintrag> getWortEinträge() {
        return new ArrayList<>(wortEinträge);  // defensive copy
    }

    public void addWort(WortEintrag wort) {
        if (wort != null) {
            wortEinträge.add(wort);
        } else {
            throw new IllegalArgumentException("WortEintrag darf nicht null sein");
        }
    }

    public WortEintrag getWortEintrag(int index) {
        if (index >= 0 && index < wortEinträge.size()) {
            return wortEinträge.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index außerhalb des Bereichs");
        }
    }

    /**
     * Diese Methode sucht die eingegebene
     * Bezeichnung und löscht dieses von den Worteinträgen.
     * @param bezeichnung ist die eingegebene Bezeichnung
     * @return gibt zurück, ob die Bezeichnung erfolgreich gelöscht werden konnte
     */
    public boolean loeschWort(String bezeichnung) {
        return wortEinträge.removeIf(wort -> wort.getWort().equals(bezeichnung));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (WortEintrag eintrag : wortEinträge) {
            sb.append(eintrag.getWort()).append(" ").append(eintrag.getURL()).append("\n");
        }
        return sb.toString();
    }

    //public List<WortEintrag> getWorteinträge() {
    //    return wortEinträge;
    //}

}

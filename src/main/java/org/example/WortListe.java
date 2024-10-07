package org.example;

import java.util.ArrayList;
import java.util.List;

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

    // Neue Methode
    public List<WortEintrag> getWorteinträge() {
        return new ArrayList<>(wortEinträge); // defensive copy
    }
}

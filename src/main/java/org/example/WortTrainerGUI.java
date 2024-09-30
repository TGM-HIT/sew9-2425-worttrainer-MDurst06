package org.example;

import javax.swing.*;

public class WortTrainerGUI {
    public static void main(String[] args) {
        WortListe liste = new WortListe();
        liste.addWort(new WortEintrag("Hund", "https://example.com/hund"));
        liste.addWort(new WortEintrag("Katze", "https://example.com/katze"));

        WortTrainer trainer = new WortTrainer(liste);
        String wort = trainer.WortZufall();

        while (wort != null) {
            String input = JOptionPane.showInputDialog("Was ist das Wort für das Bild: " + wort);
            if (input == null) break; // Bei Abbrechen
            boolean richtig = trainer.checkIgnoreCase(input);
            String message = richtig ? "Richtig!" : "Falsch, das richtige Wort war: " + trainer.WortAktuell();
            JOptionPane.showMessageDialog(null, message);
            wort = trainer.WortZufall();
        }
    }
}

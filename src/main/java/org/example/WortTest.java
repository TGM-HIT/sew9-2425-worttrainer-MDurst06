package org.example;

import java.io.IOException;

public class WortTest {
    public static void main(String[] args) {
        try {
            // Erstelle einige WortEinträge
            WortEintrag eintrag1 = new WortEintrag("Hund", "https://example.com/hund.jpg");
            WortEintrag eintrag2 = new WortEintrag("Katze", "https://example.com/katze.jpg");

            WortListe wortListe = new WortListe();
            wortListe.addWort(eintrag1);
            wortListe.addWort(eintrag2);

            WortTrainer trainer = new WortTrainer(wortListe);
            trainer.wortZufall();  // Ein Wort auswählen

            // Speicherstrategie festlegen (JSON in diesem Fall)
            PersistenceStrategy jsonStrategy = new JSONPersistenceStrategy();

            // Speichern
            jsonStrategy.save(trainer, "C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.txt");
            System.out.println("Daten gespeichert!");

            // Laden
            WortTrainer geladenerTrainer = jsonStrategy.load("C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.txt");
            System.out.println("Daten geladen: " + geladenerTrainer.getWortListe());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

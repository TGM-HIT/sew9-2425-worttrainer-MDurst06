package org.example;

import java.io.*;

/**
 * Die Klasse WortTrainerSpeichern speichert die aufgenommenen
 * Ergebnisse des Worttrainers und speichert sie in einer txt
 * Datei
 * @author Manuel Durst
 * @version 02-10-2024
 */
public class WortTrainerSpeichern {
    private static final String DEFAULT_PFAD = "C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.txt";
    private WortTrainer wortTrainer;

    public WortTrainerSpeichern(WortTrainer wortTrainer) {
        if (wortTrainer == null) {
            throw new IllegalArgumentException("WortTrainer darf nicht null sein");
        }
        this.wortTrainer = wortTrainer;
    }

    /**
     * Die Methode speichern speichert die aufgenommenen Ergebnisse in
     * einen übergebenen Dateipfad.
     * @param pfad ist der übergebene Dateipfad
     * @throws IOException
     */
    public void speichern(String pfad) throws IOException {
        File file = new File(pfad);
        try (FileWriter writer = new FileWriter(file)) {
            for (WortEintrag eintrag : wortTrainer.getWortListe().getWortEinträge()) {
                writer.write(eintrag.toString());
                writer.write(System.lineSeparator());
            }
            writer.write(wortTrainer.abfrageRichtigToString());
        } catch (IOException e) {
            throw new IOException("Fehler beim Speichern der Datei", e);
        }
    }

    /**
     * Die Methode speichern speichert die aufgenommenen Ergebnisse in
     * den default Dateipfad.
     * @throws IOException
     */
    public void speichern() throws IOException {
        speichern(DEFAULT_PFAD);
    }

    /**
     * Die Methode laden lädt die aufgenommenen Ergebnisse einer
     * txt Datei eines übergebenen Dateipfads.
     * @param pfad ist der übergebene Dateipfad
     * @throws IOException
     */
    public void laden(String pfad) throws IOException {
        File file = new File(pfad);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Implementierung für das Einlesen der Daten
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Die Datei wurde nicht gefunden");
        }
    }

    /**
     * Die Methode laden lädt die aufgenommenen Ergebnisse einer
     * txt Datei des default Dateipfads.
     * @throws IOException
     */
    public void laden() throws IOException {
        laden(DEFAULT_PFAD);
    }
}

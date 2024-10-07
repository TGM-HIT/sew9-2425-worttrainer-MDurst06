package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A JSON-based implementation of the PersistenceStrategy interface.
 * This class provides methods to save and load WortTrainer data to and from a JSON file.
 *
 * @author Manuel Durst
 * @version 2024-10-06
 */
public class JSONPersistenceStrategy implements PersistenceStrategy {

    /**
     * Saves the WortTrainer data to the specified path in JSON format.
     *
     * @param trainer the WortTrainer instance to save
     * @param path the file path where the data should be saved
     * @throws IOException if an I/O error occurs during saving
     */
    @Override
    public void save(WortTrainer trainer, String path) throws IOException {
        JSONObject jsonObject = new JSONObject();

        // Save the word entries
        JSONArray wortListeArray = new JSONArray();
        for (WortEintrag eintrag : trainer.getWortListe().getWortEinträge()) {
            JSONObject eintragObj = new JSONObject();
            eintragObj.put("wort", eintrag.getWort());
            eintragObj.put("url", eintrag.getURL());
            wortListeArray.put(eintragObj);
        }
        jsonObject.put("wortListe", wortListeArray);

        // Save the currently selected word
        jsonObject.put("aktuellesWort", trainer.wortAktuell() == null ? JSONObject.NULL : trainer.wortAktuell());

        // Save the statistics
        jsonObject.put("abfragen", trainer.getAbfrage());
        jsonObject.put("richtig", trainer.getRichtig());

        // Write to the file
        try (FileWriter file = new FileWriter(path)) {
            file.write(jsonObject.toString());
        }
    }

    /**
     * Loads the WortTrainer data from the specified path in JSON format.
     *
     * @param path the file path from where the data should be loaded
     * @return the loaded WortTrainer instance
     * @throws IOException if an I/O error occurs during loading
     */
    @Override
    public WortTrainer load(String path) throws IOException {
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                jsonData.append(line);
            }
        }

        JSONObject jsonObject = new JSONObject(jsonData.toString());

        // Load the word list
        WortListe wortListe = new WortListe();
        JSONArray wortListeArray = jsonObject.getJSONArray("wortListe");
        for (int i = 0; i < wortListeArray.length(); i++) {
            JSONObject eintragObj = wortListeArray.getJSONObject(i);
            wortListe.addWort(new WortEintrag(eintragObj.getString("wort"), eintragObj.getString("url")));
        }

        WortTrainer trainer = new WortTrainer(wortListe);

        // Load the currently selected word
        if (!jsonObject.isNull("aktuellesWort")) {
            String aktuellesWort = jsonObject.getString("aktuellesWort");
            trainer.setAktuellesWort(aktuellesWort);  // Setter for the current word
        }

        // Load the statistics
        trainer.setAbfrage(jsonObject.getInt("abfragen"));  // Setter for queries
        trainer.setRichtig(jsonObject.getInt("richtig"));   // Setter for correct answers

        return trainer;
    }
}
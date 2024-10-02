package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class JSONPersistenceStrategy implements PersistenceStrategy {

    @Override
    public void save(WortTrainer trainer, String path) throws IOException {
        JSONObject jsonObject = new JSONObject();

        // Speichere die Wort-Einträge
        JSONArray wortListeArray = new JSONArray();
        for (WortEintrag eintrag : trainer.getWortListe().getWortEinträge()) {
            JSONObject eintragObj = new JSONObject();
            eintragObj.put("wort", eintrag.getWort());
            eintragObj.put("url", eintrag.getURL());
            wortListeArray.put(eintragObj);
        }
        jsonObject.put("wortListe", wortListeArray);

        // Speichere das aktuell ausgewählte Wort
        jsonObject.put("aktuellesWort", trainer.wortAktuell() == null ? JSONObject.NULL : trainer.wortAktuell());

        // Speichere die Statistik
        jsonObject.put("abfragen", trainer.getAbfrage());
        jsonObject.put("richtig", trainer.getRichtig());

        // Schreibe in die Datei
        try (FileWriter file = new FileWriter(path)) {
            file.write(jsonObject.toString());
        }
    }

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

        // Lade die WortListe
        WortListe wortListe = new WortListe();
        JSONArray wortListeArray = jsonObject.getJSONArray("wortListe");
        for (int i = 0; i < wortListeArray.length(); i++) {
            JSONObject eintragObj = wortListeArray.getJSONObject(i);
            wortListe.addWort(new WortEintrag(eintragObj.getString("wort"), eintragObj.getString("url")));
        }

        WortTrainer trainer = new WortTrainer(wortListe);

        // Lade das aktuell ausgewählte Wort
        if (!jsonObject.isNull("aktuellesWort")) {
            String aktuellesWort = jsonObject.getString("aktuellesWort");
            trainer.setAktuellesWort(aktuellesWort);  // Setter für das aktuelle Wort
        }

        // Lade die Statistik
        trainer.setAbfrage(jsonObject.getInt("abfragen"));  // Setter für Abfrage
        trainer.setRichtig(jsonObject.getInt("richtig"));   // Setter für Richtig

        return trainer;
    }
}

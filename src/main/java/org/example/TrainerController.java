package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * TrainerController is responsible for handling user actions and updating the TrainerPanel view.
 * It interacts with the WortTrainer model and uses a PersistenceStrategy for saving and loading data.
 *
 * @author Manuel Durst
 * @version 2024-10-06
 */
public class TrainerController implements ActionListener {
    private TrainerPanel view;
    private WortTrainer wt;
    private PersistenceStrategy persistenceStrategy; // Hier definieren wir die Persistenzstrategie

    /**
     * Constructs a TrainerController with the specified WortTrainer and PersistenceStrategy.
     *
     * @param wt the WortTrainer model
     * @param persistenceStrategy the strategy for saving and loading data
     * @throws MalformedURLException if the URL for the initial word image is malformed
     */
    public TrainerController(WortTrainer wt, PersistenceStrategy persistenceStrategy) throws MalformedURLException {
        this.view = new TrainerPanel(this);
        this.wt = wt;
        this.persistenceStrategy = persistenceStrategy; // Initialisierung der Persistenzstrategie
        this.view.setUrl(this.wt.wortZufall().getURL());
        this.view.update(wt.getRichtig(), wt.getAbfrage());
    }

    /**
     * Gets the WortTrainer model.
     *
     * @return the WortTrainer model
     */
    public WortTrainer getWt() {
        return wt;
    }

    /**
     * Gets the TrainerPanel view.
     *
     * @return the TrainerPanel view
     */
    public TrainerPanel getView() {
        return view;
    }

    /**
     * Handles action events triggered by the user.
     *
     * @param e the action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        switch (com) {
            case "Zurücksetzen":
                this.wt.zuruecksetzen();
                break;
            case "Wort hinzufügen":
                // Hier könnte Code zum Hinzufügen eines neuen Wortes stehen
                break;
            case "Speichern":
                try {
                    persistenceStrategy.save(wt, "C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.json"); // Der Pfad zur JSON-Datei
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Fehler beim Speichern: " + ex.getMessage());
                }
                break;
            case "Laden":
                try {
                    WortTrainer loadedTrainer = persistenceStrategy.load("C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.json"); // Der Pfad zur JSON-Datei
                    this.wt = loadedTrainer; // Den aktuellen Trainer mit dem geladenen Trainer ersetzen
                    this.view.update(wt.getRichtig(), wt.getAbfrage());
                    this.view.setUrl(this.wt.wortZufall().getURL()); // Setzt das Bild für das neue Wort
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Fehler beim Laden: " + ex.getMessage());
                }
                break;
            default:
                String wort = view.getJText();
                boolean gleich = this.wt.checkIgnoreCase(wort);
                view.setUrl(wt.wortZufall().getURL());
                break;
        }
        try {
            this.view.update(wt.getRichtig(), wt.getAbfrage());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Fehler beim Aktualisieren der Anzeige: " + ex.getMessage());
        }
    }
}

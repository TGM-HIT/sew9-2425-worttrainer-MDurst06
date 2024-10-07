package org.example;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TrainerPanel is a custom JPanel that displays the current state of the WortTrainer.
 * It includes labels for correct and total words, an input field for word guesses,
 * and buttons for various actions such as resetting, adding words, saving, and loading.
 *
 * @author Manuel Durst
 * @version 2024-10-06
 */
public class TrainerPanel extends JPanel {
    private JLabel richtig = new JLabel("0");
    private JLabel gesamt = new JLabel("0");
    private JLabel lImage;
    private JTextField Worteingabe;
    private String url;

    /**
     * Sets the URL for the image to be displayed.
     *
     * @param url the URL of the image
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Constructs a TrainerPanel with the specified TrainerController.
     *
     * @param tc the TrainerController to handle actions
     * @throws MalformedURLException if the URL for the default image is malformed
     */
    public TrainerPanel(TrainerController tc) throws MalformedURLException {
        BorderLayout basis = new BorderLayout();
        this.setLayout(basis);

        // Hintergrund-Panel
        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setPreferredSize(new Dimension(852, 480));
        this.add(yellowLabel);

        // Oben
        JPanel panelOben = new JPanel();
        GridLayout gridl = new GridLayout(2, 1);
        panelOben.setLayout(gridl);

        JLabel ueberschrift = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        panelOben.add(ueberschrift);

        // Eingabefeld
        this.Worteingabe = new JTextField("", 15);
        Worteingabe.setBackground(Color.WHITE);
        panelOben.add(Worteingabe);
        Worteingabe.addActionListener(tc);
        this.add(panelOben, BorderLayout.PAGE_START);

        // Bild anzeigen
        ImageIcon icon = new ImageIcon(new URL(this.url != null ? this.url : "https://upload.wikimedia.org/wikipedia/commons/5/56/Bsodwindows10.png"));
        Image image = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        this.lImage = new JLabel(new ImageIcon(image));
        this.add(lImage, BorderLayout.CENTER);

        // Unten
        JPanel panelUnten = new JPanel(new GridLayout(3, 3));

        JLabel richtigeW = new JLabel("Richtige Wörter:");
        panelUnten.add(richtigeW);
        panelUnten.add(this.richtig);

        JButton buttonZuruecksetzen = new JButton("Zurücksetzen");
        panelUnten.add(buttonZuruecksetzen);
        buttonZuruecksetzen.addActionListener(tc);

        JLabel anzahlW = new JLabel("Anzahl Wörter:");
        panelUnten.add(anzahlW);
        panelUnten.add(this.gesamt);

        JButton buttonhinzufuegen = new JButton("Wort hinzufügen");
        panelUnten.add(buttonhinzufuegen);
        buttonhinzufuegen.addActionListener(tc);

        JButton buttonSpeichern = new JButton("Speichern");
        panelUnten.add(buttonSpeichern);
        buttonSpeichern.addActionListener(tc);

        JButton buttonLaden = new JButton("Laden");
        panelUnten.add(buttonLaden);
        buttonLaden.addActionListener(tc);

        this.add(panelUnten, BorderLayout.PAGE_END);
    }

    /**
     * Updates the display with the current number of correct and total words.
     *
     * @param richtig the number of correct words
     * @param gesamt the total number of words
     * @throws MalformedURLException if the URL for the image is malformed
     */
    public void update(int richtig, int gesamt) throws MalformedURLException {
        this.richtig.setText("" + richtig);
        this.gesamt.setText("" + gesamt);

        ImageIcon icon;
        try {
            icon = new ImageIcon(new URL(this.url));
        } catch (MalformedURLException e) {
            icon = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/5/56/Bsodwindows10.png"));
        }

        Image image = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        this.lImage.setIcon(new ImageIcon(image));
    }

    /**
     * Gets the text entered in the word input field.
     *
     * @return the text entered in the word input field
     */
    public String getJText() {
        return this.Worteingabe.getText();
    }
}

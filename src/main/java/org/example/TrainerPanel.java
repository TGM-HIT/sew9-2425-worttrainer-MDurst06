package org.example;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class TrainerPanel extends JPanel {
    private JLabel richtig = new JLabel("0");
    private JLabel gesamt = new JLabel("0");
    private JLabel lImage;
    private JTextField Worteingabe;

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public TrainerPanel(org.example.TrainerController tc) throws MalformedURLException {
        BorderLayout basis = new BorderLayout();
        this.setLayout(basis);


        JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setPreferredSize(new Dimension(852, 480));
        this.add(yellowLabel);

        //Grouplayout oben
        JPanel panelOben = new JPanel();
        GridLayout gridl = new GridLayout(2, 1);
        panelOben.setLayout(gridl);

        JLabel ueberschrift = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        panelOben.add(ueberschrift);

        //Textfield
        this.Worteingabe = new JTextField("", 15);
        Worteingabe.setBackground(Color.WHITE);
        panelOben.add(Worteingabe);
        Worteingabe.addActionListener(tc);
        this.add(panelOben, BorderLayout.PAGE_START);

        //Mitte
        ImageIcon icon;
        if (this.url != null) {
            icon = new ImageIcon(new URL(this.url));
        }else{
            icon = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/5/56/Bsodwindows10.png"));
        }
        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250, 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe
        this.lImage = new JLabel(new ImageIcon(image));// anzeigen in einem JLabel
        this.add(lImage, BorderLayout.CENTER);

        //Grouplayout unten
        JPanel panelUnten = new JPanel(new GridLayout(3, 3));

        //1. Reihe
        JLabel richtigeW = new JLabel("Richtige Wörter:");
        panelUnten.add(richtigeW);

        //Output

        panelUnten.add(this.richtig);

        JButton buttonZuruecksetzen = new JButton("Zurücksetzen");
        panelUnten.add(buttonZuruecksetzen);
        buttonZuruecksetzen.addActionListener(tc);

        //2. Reihe
        JLabel anzahlW = new JLabel("Anzahl Wörter:");
        panelUnten.add(anzahlW);

        //Output

        panelUnten.add(this.gesamt);

        JButton buttonhinzufuegen = new JButton("Wort hinzufügen");
        panelUnten.add(buttonhinzufuegen);
        buttonhinzufuegen.addActionListener(tc);


        //3. Reihe
        JButton buttonSpeichern = new JButton("Speichern");
        panelUnten.add(buttonSpeichern);
        buttonSpeichern.addActionListener(tc);

        JButton buttonLaden = new JButton("Laden");
        panelUnten.add(buttonLaden);
        buttonLaden.addActionListener(tc);

        this.add(panelUnten, BorderLayout.PAGE_END);
    }

    /**
     * Diese Methode updated das Panel
     * @param richtig gibt die richtigen antworten
     * @param gesamt gibt alle antworten
     * @throws MalformedURLException
     */
    public void update(int richtig, int gesamt) throws MalformedURLException {
        this.richtig.setText("" + richtig);
        this.gesamt.setText("" + gesamt);

        ImageIcon icon;
        try{
            icon = new ImageIcon(new URL(this.url));
        } catch(MalformedURLException e){
            icon = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/commons/5/56/Bsodwindows10.png"));
        }

        Image image = icon.getImage(); // umwandeln in ein Image-Objekt
        image = image.getScaledInstance(250 , 250,  Image.SCALE_SMOOTH); // skalieren auf gewünschte Größe

        this.lImage.setIcon(new ImageIcon(image));
    }
    public String getJText (){
        String text = this.Worteingabe.getText();
        return text;
    }

    public void wortKorrekt(int r, int g){
        this.richtig.setText("" + r);
        this.gesamt.setText("" + g);
    }

    public void wortFalsch(int r, int g){
        this.richtig.setText("" + r);
        this.gesamt.setText("" + g);
    }
}

package org.example;

import javax.swing.*;

public class WortTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersistenceStrategy persistenzStrategie = new JSONPersistenceStrategy();
            WortTrainer wortTrainer;

            // Lade Daten oder initialisiere eine neue WortListe
            try {
                wortTrainer = persistenzStrategie.load("C:\\Users\\Manuel\\Documents\\5CHIT\\SEW\\9a.1WorttrainerReloaded\\WorttrainerExtended_speichern.txt");
            } catch (Exception e) {
                WortListe wortListe = new WortListe();
                wortListe.addWort(new WortEintrag("Hase", "https://img.freepik.com/fotos-kostenlos/pelziges-niedliches-kaninchen-lokalisiert_78492-3950.jpg?w=2000"));
                wortListe.addWort(new WortEintrag("Hund", "https://cdn.drhoelter.de/x/fit/768/0/sm/0/plain/https://drhoelter-hund.jpeg.jpg"));
                wortListe.addWort(new WortEintrag("Katze", "https://p6.focus.de/img/fotos/id_7374476/urn-newsml-dpa-com-20090101-170719-99-305718-large-4-3.jpg"));
                wortListe.addWort(new WortEintrag("Maus", "https://www.zooroyal.de/magazin/wp-content/uploads/2017/05/maus-760x560.jpg"));

                wortTrainer = new WortTrainer(wortListe);
            }

            //TrainerPanel panel = new TrainerPanel();
            //TrainerController controller = new TrainerController(wortTrainer, panel);

            // Erstelle das JFrame und füge das Panel hinzu
            JFrame frame = new JFrame("Worttrainer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

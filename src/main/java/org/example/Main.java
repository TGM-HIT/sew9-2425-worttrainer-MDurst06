package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                WortListe wortListe = new WortListe();
                wortListe.addWort(new WortEintrag("Kaninchen", "https://img.freepik.com/fotos-kostenlos/pelziges-niedliches-kaninchen-lokalisiert_78492-3950.jpg?w=2000"));
                wortListe.addWort(new WortEintrag("Auto", "https://cf-static-cms.dasweltauto.at/Plone/at/assets/seo-landingpages/porsche-911-seitenansicht.png/@@images/1adc97fc-fdfd-4165-8200-7b24344ffb89.png"));
                wortListe.addWort(new WortEintrag("Haus", "https://media.danwood.pl/hero_slide/v1/uploads/media/64240d5aa8822/zmniejszony-rozmiar-fam108.jpg"));
                wortListe.addWort(new WortEintrag("Maus", "https://www.zooroyal.de/magazin/wp-content/uploads/2017/05/maus-760x560.jpg"));
                wortListe.addWort(new WortEintrag("Kacper", "https://sustainable-edu.at/img/bohaczyk.jpg"));
                wortListe.addWort(new WortEintrag("Leo", "https://sustainable-edu.at/img/muehlboeck.jpg"));

                WortTrainer wortTrainer = new WortTrainer(wortListe);

                PersistenceStrategy persistenceStrategy = new JSONPersistenceStrategy();

                new TrainerFrame(wortTrainer, persistenceStrategy);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

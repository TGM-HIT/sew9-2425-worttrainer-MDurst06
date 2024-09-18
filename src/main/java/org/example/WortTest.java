package org.example;

/**
 * Diese Klasse testet das Programm Worttrainer
 * @author Manuel Durst
 * @version 2022-09-11
 */
public class WortTest {
    /**
     * Dies ist die Test-Methode. Sie testet die Klassen
     * Worteintrag, Worttrainer und Wortliste
     */
    public static void main(String[] args){

        //Worteintrag Test
        System.out.println("\nTest von Worteintrag:");
        WortEintrag laptop = new WortEintrag("laptop", "https:/a.bhttp://");
        boolean urlRichtig = WortEintrag.checkURL(laptop.getURL());
        String laptopText = laptop.toString();
        System.out.println(laptopText);
        System.out.println("Ist die URL von dem Worteintrag gültig: " + urlRichtig);

        //Test von Wortliste
        System.out.println("\nTest von Wortliste:");
        WortListe liste = new WortListe();
        liste.addWort(new WortEintrag("SEW", "https://s.w.com"));
        liste.addWort(new WortEintrag("SYT", "https://s.y.com"));
        liste.addWort(new WortEintrag("MEDT", "https://m.e.com"));

        System.out.println(liste.toString());
        System.out.println("SYT wird gelöscht und ITSI wird hinzugefügt:");
        liste.loeschWort("SYT");
        liste.addWort(new WortEintrag("ITSI", "https://i.t.com"));
        System.out.println(liste.toString());

        //Test von WortTrainer
        System.out.println("\nTest von WortTrainer");
        WortTrainer trainer = new WortTrainer(liste);
        String zufall = trainer.WortZufall();
        System.out.println("Zufälliges Wort: " + zufall);
        System.out.println("Ausgewähltes Wort wird mit Hallo verglichen");
        System.out.println(trainer.check("Hallo"));
        System.out.println("Ausgewähltes Wort wird mit SEW verglichen");
        System.out.println(trainer.check("SEW"));

    }
}
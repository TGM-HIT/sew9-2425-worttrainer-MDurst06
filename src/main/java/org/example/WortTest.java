package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Die Klasse WortTest testet die bisher überarbeiteten Klassen
 * @author Manuel Durst
 * @version 02-10-2024
 */
public class WortTest {
    public static void main(String[] args) throws IOException, MalformedURLException {
        WortListe liste = new WortListe();

        // Wörter zur Liste hinzufügen
        liste.addWort(new WortEintrag("Hase", "https://img.freepik.com/fotos-kostenlos/pelziges-niedliches-kaninchen-lokalisiert_78492-3950.jpg?w=2000"));
        liste.addWort(new WortEintrag("Hund", "https://cdn.drhoelter.de/x/fit/768/0/sm/0/plain/https://drhoelter-hund.jpeg.jpg"));
        liste.addWort(new WortEintrag("Katze", "https://p6.focus.de/img/fotos/id_7374476/urn-newsml-dpa-com-20090101-170719-99-305718-large-4-3.jpg"));
        liste.addWort(new WortEintrag("Maus", "https://www.zooroyal.de/magazin/wp-content/uploads/2017/05/maus-760x560.jpg"));

        // WortTrainer erstellen
        WortTrainer tr = new WortTrainer(liste);

        // Ausgabe der Wortliste
        System.out.println("Wortliste nach dem Hinzufügen:");
        System.out.println(liste);

        // Training mit Benutzereingabe
        Scanner scanner = new Scanner(System.in);
        boolean training = true;

        while (training) {
            // Zufälliges Wort auswählen
            WortEintrag eintrag = tr.wortZufall();
            System.out.println("Zufällig ausgewähltes Wort: " + eintrag.getWort() + " (URL: " + eintrag.getURL() + ")");

            // Benutzer nach dem Wort fragen
            System.out.print("Geben Sie das Wort ein (oder 'exit' zum Beenden): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                training = false;  // Training beenden
            } else {
                boolean richtig = tr.checkIgnoreCase(input);
                if (richtig) {
                    System.out.println("Wort richtig geraten!");
                } else {
                    System.out.println("Wort falsch geraten! Richtig wäre: " + tr.wortAktuell());
                }
            }

            // Ausgabe der Statistiken
            System.out.println(tr.abfrageRichtigToString());
        }

        scanner.close();
    }
}

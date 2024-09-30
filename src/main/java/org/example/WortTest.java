package org.example;
import java.io.IOException;
import java.net.MalformedURLException;

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
    public static void main(String[] args) throws IOException, MalformedURLException {

        WortListe liste = new WortListe();
        liste.addWort(new WortEintrag("Hase", "https://img.freepik.com/fotos-kostenlos/pelziges-niedliches-kaninchen-lokalisiert_78492-3950.jpg?w=2000"));
        liste.addWort(new WortEintrag("Hund", "https://cdn.drhoelter.de/x/fit/768/0/sm/0/plain/https%3A//www.drhoelter.de/media/fb/3f/38/1663659307/6aMnH5K3PaU1_drhoelter%20exokrine%20pankreasinsuffizienz%20hund.jpeg.jpg"));
        liste.addWort(new WortEintrag("Katze", "https://p6.focus.de/img/fotos/id_7374476/urn-newsml-dpa-com-20090101-170719-99-305718-large-4-3.jpg?im=Crop%3D%28100%2C0%2C600%2C600%29%3BResize%3D%28548%29&impolicy=perceptual&quality=medium&hash=53fd3d070d16e04ac4b12a9e8c2a261580715fa2ad17d7f3002476ffd1ca8c92"));
        liste.addWort(new WortEintrag("Maus", "https://www.zooroyal.de/magazin/wp-content/uploads/2017/05/maus-760x560.jpg"));


        WortTrainer tr = new WortTrainer(liste);
        WortTrainerSpeichern test = new WortTrainerSpeichern(tr);
        new org.example.TrainerFrame(tr);
    }
}
//Git: https://github.com/TGM-HIT/wortliste-MDurst06
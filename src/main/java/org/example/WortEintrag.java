package org.example;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Diese Klasse übernimmt ein Wort und eine URL.
 * Die URL wird später geprüft, ob diese auch gültig ist.
 * @author Manuel Durst
 * @version 2022-09-11
 */

public class WortEintrag {
    private String Wort;
    private String URL;

    /**
     * Konstruktor
     * @param Wort ist das übergebene Wort
     * @param URL ist die übergebene URL
     */
    public WortEintrag(String Wort, String URL) {
        if(Wort.length() >= 2) {
            this.Wort = Wort;
        }
        else{
            System.err.println("Das Wort muss mindestens 2 Buchstaben beinhalten");
        }
        this.URL = URL;
    }

    /**
     * Bei der Methode checkURL wird überprüft,
     * ob die übergebene URL gültig ist.
     * @return gibt die Gültigkeit zurück
     */
    public static boolean checkURL(String URL){

        if(URL.startsWith("https://")){
            char c1 = URL.charAt(8);
            if (!(c1 >= 'A' && c1 <= 'Z') && !(c1 >= 'a' && c1 <= 'z')) {
                return false;
            }
            if(!(URL.charAt(9) == '.')){
                return false;
            }
            char c2 = URL.charAt(10);
            if (!(c2 >= 'A' && c2 <= 'Z') && !(c2 >= 'a' && c2 <= 'z')) {
                return false;
            }
            return true;
        }
        else if(URL.startsWith("http://")){
            char c1 = URL.charAt(7);
            if (!(c1 >= 'A' && c1 <= 'Z') && !(c1 >= 'a' && c1 <= 'z')) {
                return false;
            }
            if(!(URL.charAt(8) == '.')){
                return false;
            }
            char c2 = URL.charAt(9);
            if (!(c2 >= 'A' && c2 <= 'Z') && !(c2 >= 'a' && c2 <= 'z')) {
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Getter Methode von Wort
     * @return gibt das Attribut Wort zurück
     */
    public String getWort() {
        return Wort;
    }

    /**
     * Getter Methode von URL
     * @return gibt das Attribut URL zurück
     */
    public String getURL() {
        return URL;
    }

    /**
     * Diese Methode ändert die Methode toString der Superklasse.
     * Es werden die Daten zu einem text zusammengefasst
     * @return gibt den erstellten Text zurück
     */
    @Override
    public String toString(){
        return this.Wort + ";" + this.URL;
    }

}

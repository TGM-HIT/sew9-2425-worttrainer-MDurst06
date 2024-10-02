package org.example;

import java.net.MalformedURLException;

/**
 * Diese Klasse übernimmt ein Wort und eine URL.
 * Die URL wird später geprüft, ob diese auch gültig ist.
 * @author Manuel Durst
 * @version 02-10-2024
 */
public class WortEintrag {
    private String wort;
    private String url;

    /**
     * Konstruktor
     * @param wort ist das übergebene Wort
     * @param url ist die übergebene URL
     */
    public WortEintrag(String wort, String url) {
        if (wort != null && wort.length() >= 2) {
            this.wort = wort;
        } else {
            throw new IllegalArgumentException("Das Wort muss mindestens 2 Buchstaben beinhalten");
        }

        if (checkURL(url)) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("Ungültige URL");
        }
    }

    public String getWort() {
        return wort;
    }

    public String getURL() {
        return url;
    }

    /**
     * Bei der Methode checkURL wird überprüft,
     * ob die übergebene URL gültig ist.
     * @return gibt die Gültigkeit zurück
     */
    public static boolean checkURL(String url) {
        if (url == null) {
            return false;
        }

        try {
            new java.net.URL(url);
            return url.startsWith("http://") || url.startsWith("https://");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return this.wort + ";" + this.url;
    }
}

package org.example;
import java.io.*;

public class WortTrainerSpeichern{
    private final String pfad = "C:\\Users\\Manuel\\Documents\\3CHIT\\SEW\\WorttrainerSpeichern\\test.txt";

    private WortTrainer tr;

    public WortTrainerSpeichern(WortTrainer tr){
        this.tr = tr;
    }

    /**
     * Diese Methode speichert die Wortliste an dem angegebenen Pfad
     * @param pfad übergebener Pfad
     * @throws IOException
     */
    public void speichern(String pfad) throws IOException {
        File f = new File(pfad);
        FileWriter outputStream = null;
        try{
            WortEintrag[] eintraege = tr.getWortListe().getWorteinträge();
            outputStream = new FileWriter(f);
            for (int i = 0; i < eintraege.length; ++i) {
                outputStream.write(eintraege[i].toString());
                outputStream.write(System.lineSeparator());
            }

            outputStream.write(tr.AbfrageRichtigToString());

        } catch (FileNotFoundException fe ){
            System.err.println("Ungültiger Pfad!");
        }
        finally {
            if (outputStream != null)
                outputStream.close();
        }
    }

    /**
     * Diese Methode speichert die Wortliste an dem Default Pfad
     * @throws IOException
     */
    public void speichern() throws IOException {
        speichern(this.pfad);
    }

    /**
     * Diese Methode ladet die Wortliste von dem angegebenen Pfad
     * @param pfad übergebener Pfad
     * @throws IOException
     */
    public void laden(String pfad) throws IOException {
        try (BufferedReader inputStream = new BufferedReader(new
                FileReader(pfad))) {
            String text;
            while ((text = inputStream.readLine()) != null) {
                System.out.println(text);
            }
        } catch (FileNotFoundException fe ){
            System.err.println("Ungültiger Pfad!");
        }
    }

    /**
     *Diese Methode speichert die Wortliste von dem default Pfad
     * @throws IOException
     */
    public void laden() throws IOException {
        laden(this.pfad);
    }


}
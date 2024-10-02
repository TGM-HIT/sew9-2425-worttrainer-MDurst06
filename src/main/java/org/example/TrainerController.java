package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

public class TrainerController implements ActionListener {
    private TrainerPanel view;
    private WortTrainer wt;
    private WortTrainerSpeichern wts;

    public TrainerController(WortTrainer wt) throws MalformedURLException {
        this.view = new TrainerPanel(this);
        this.wt = wt;
        this.wts = new WortTrainerSpeichern(wt);
        //this.view.setUrl(this.wt.WortZufall().getURL());
        this.view.update(wt.getRichtig(), wt.getAbfrage());
    }
    public WortTrainer getWt(){
        return wt;
    }

    public TrainerPanel getView() {
        return view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        switch(com){
            case "Zurücksetzen":
                //this.wt.zuruecksetzen();
                break;

            case "Wort hinzufügen":
                break;

            case "Speichern":
                try {
                    wts.speichern();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            case "Laden":
                try {
                    wts.laden();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;

            default:
                String wort = view.getJText();
                //boolean gleich = this.wt.checkIgnoreCase(wort);
                //view.setUrl(wt.WortZufall().getURL());
                break;
        }
        try {
            this.view.update(wt.getRichtig(), wt.getAbfrage());
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }


}

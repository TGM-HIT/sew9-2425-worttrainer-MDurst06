package org.example;
import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;

public class TrainerFrame extends JFrame {
    public TrainerFrame(WortTrainer wt) throws MalformedURLException {
        super("Worttrainer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        org.example.TrainerController tc = new org.example.TrainerController(wt);
        TrainerPanel content = tc.getView();
        this.add(content);
        this.pack();
        this.setVisible(true);
    }
}
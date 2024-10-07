package org.example;

import javax.swing.*;
import java.net.MalformedURLException;

/**
 * TrainerFrame is the main JFrame for the Worttrainer application
 * It initializes the frame with a given WortTrainer and PersistenceStrategy.
 *
 * @author Manuel Durst
 * @version 2024-10-06
 */
public class TrainerFrame extends JFrame {

/**
     * Constructs a new TrainerFrame.
     *
     * @param wt the WortTrainer instance
     * @param persistenceStrategy the PersistenceStrategy instance
     * @throws MalformedURLException if an error occurs while setting the URL
     */
    public TrainerFrame(WortTrainer wt, PersistenceStrategy persistenceStrategy) throws MalformedURLException {
        super("Worttrainer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TrainerController tc = new TrainerController(wt, persistenceStrategy);
        TrainerPanel content = tc.getView();
        this.add(content);
        this.pack();
        this.setVisible(true);
    }
}

package org.example;

import java.io.IOException;

/**
 * Interface for persistence strategies to save and load WortTrainer data.
 *
 * @author Manuel Durst
 * @version 2024-10-06
 */
public interface PersistenceStrategy {
    /**
     * Saves the WortTrainer data to the specified path.
     *
     * @param trainer the WortTrainer instance to save
     * @param path the file path where the data should be saved
     * @throws IOException if an I/O error occurs during saving
     */
    void save(WortTrainer trainer, String path) throws IOException;

    /**
     * Loads the WortTrainer data from the specified path.
     *
     * @param path the file path from where the data should be loaded
     * @return the loaded WortTrainer instance
     * @throws IOException if an I/O error occurs during loading
     */
    WortTrainer load(String path) throws IOException;
}
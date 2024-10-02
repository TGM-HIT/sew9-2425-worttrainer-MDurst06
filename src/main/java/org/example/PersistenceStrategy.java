package org.example;

import java.io.IOException;

public interface PersistenceStrategy {
    void save(WortTrainer trainer, String path) throws IOException;
    WortTrainer load(String path) throws IOException;
}

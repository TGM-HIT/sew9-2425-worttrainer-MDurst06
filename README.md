### Projektname: WortTrainer

#### Beschreibung
WortTrainer ist eine Java-basierte Anwendung, die Benutzern hilft, Vokabeln zu lernen und zu üben. Die Anwendung ermöglicht es Benutzern, Wörter zusammen mit den entsprechenden Bildern hinzuzufügen, ihren Fortschritt zu speichern und zuvor gespeicherte Daten mit verschiedenen Persistenzstrategien zu laden.

#### Funktionen
- Hinzufügen und Verwalten von Vokabeleinträgen.
- Speichern und Laden von Vokabeldaten mit JSON.
- Benutzeroberfläche zur Interaktion mit dem Vokabeltrainer.
- Verfolgen und Anzeigen von Benutzerstatistiken.

#### Verwendete Technologien
- Java
- JSON
- Swing (für GUI)
- Gradle (für Build-Automatisierung)

#### Projektstruktur
```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── example
│   │   │           ├── Main.java
│   │   │           ├── WortTest.java
│   │   │           ├── TrainerFrame.java
│   │   │           ├── TrainerController.java
│   │   │           ├── TrainerPanel.java
│   │   │           ├── WortTrainer.java
│   │   │           ├── WortListe.java
│   │   │           ├── WortEintrag.java
│   │   │           ├── PersistenceStrategy.java
│   │   │           └── JSONPersistenceStrategy.java
│   │   └── resources
│   └── test
│       └── java
│           └── org
│               └── example
│                   └── WortTrainerTest.java
├── build.gradle
└── README.md
```

#### Installation
1. Klone das Repository:
    ```sh
    git clone https://github.com/MDurst06/WortTrainer.git
    ```
2. Navigiere in das Projektverzeichnis:
    ```sh
    cd WortTrainer
    ```
3. Baue das Projekt mit Gradle:
    ```sh
    gradle build
    ```

#### Verwendung
1. Starte die Anwendung:
    ```sh
    gradle run
    ```
2. Verwende die GUI, um Wörter hinzuzufügen, Statistiken anzuzeigen und Daten zu speichern/laden.

#### Klassen und Verantwortlichkeiten
- **Main**: Einstiegspunkt der Anwendung.
- **WortTest**: Testklasse für die Anwendung.
- **TrainerFrame**: Hauptfenster der Anwendung.
- **TrainerController**: Handhabt die Logik und Interaktionen zwischen Modell und Ansicht.
- **TrainerPanel**: GUI-Panel mit den Benutzeroberflächenkomponenten.
- **WortTrainer**: Verwalten der Wortliste und Benutzerstatistiken.
- **WortListe**: Enthält die Liste der `WortEintrag`-Objekte.
- **WortEintrag**: Repräsentiert einen einzelnen Vokabeleintrag.
- **PersistenceStrategy**: Schnittstelle zum Speichern und Laden von Daten.
- **JSONPersistenceStrategy**: Implementierung von `PersistenceStrategy` mit JSON.

#### Beitrag leisten
1. Forke das Repository.
2. Erstelle einen neuen Branch:
    ```sh
    git checkout -b feature-branch
    ```
3. Mache deine Änderungen und committe sie:
    ```sh
    git commit -m "Beschreibung der Änderungen"
    ```
4. Pushe in den Branch:
    ```sh
    git push origin feature-branch
    ```
5. Erstelle einen Pull-Request.

#### Lizenz
Dieses Projekt ist unter der MIT-Lizenz lizenziert. Siehe die `LICENSE`-Datei für Details.

#### Kontakt
Für Fragen oder Vorschläge kontaktiere bitte Manuel Durst unter mdurst@student.tgm.ac.at.

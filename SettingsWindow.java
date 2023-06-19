package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SettingsWindow {
    private Toggle difficultyToggle;
    private Toggle startsToggle;
    private ToggleGroup playerToggleGroup;
    private ToggleGroup difficultyToggleGroup;
    private ToggleGroup startsToggleGroup;

    public boolean displaySettingsWindow(Stage primaryStage) {
        // Utworzenie nowego okna ustawień
        Stage settingsStage = new Stage();
        settingsStage.initModality(Modality.WINDOW_MODAL);
        settingsStage.initOwner(primaryStage);
        settingsStage.setTitle("Ustawienia gry");
        settingsStage.initStyle(StageStyle.UTILITY);

        // Utworzenie kontrolek RadioButton dla gracza
        RadioButton humanRadioButton = new RadioButton("Człowiek");
        RadioButton botRadioButton = new RadioButton("Bot");

        // Utworzenie grupy dla RadioButton gracza
        playerToggleGroup = new ToggleGroup();
        humanRadioButton.setToggleGroup(playerToggleGroup);
        botRadioButton.setToggleGroup(playerToggleGroup);

        // Utworzenie kontrolek RadioButton dla poziomu trudności
        RadioButton easyRadioButton = new RadioButton("Łatwy");
        RadioButton mediumRadioButton = new RadioButton("Średni");
        RadioButton hardRadioButton = new RadioButton("Trudny");

        // Utworzenie grupy dla RadioButton poziomu trudności
        difficultyToggleGroup = new ToggleGroup();
        easyRadioButton.setToggleGroup(difficultyToggleGroup);
        mediumRadioButton.setToggleGroup(difficultyToggleGroup);
        hardRadioButton.setToggleGroup(difficultyToggleGroup);

        // Utworzenie kontrolek RadioButton dla kto zaczyna
        RadioButton playerStartsRadioButton = new RadioButton("Gracz zaczyna");
        RadioButton botStartsRadioButton = new RadioButton("Bot zaczyna");

        // Utworzenie grupy dla RadioButton kto zaczyna
        startsToggleGroup = new ToggleGroup();
        playerStartsRadioButton.setToggleGroup(startsToggleGroup);
        botStartsRadioButton.setToggleGroup(startsToggleGroup);

        // Ustawienie początkowego blokowania opcji
        easyRadioButton.setDisable(true);
        mediumRadioButton.setDisable(true);
        hardRadioButton.setDisable(true);
        playerStartsRadioButton.setDisable(true);
        botStartsRadioButton.setDisable(true);

        // Nasłuchiwanie zmiany zaznaczenia dla RadioButton gracza
        playerToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == humanRadioButton) {
                // Blokowanie opcji dla człowieka
                easyRadioButton.setDisable(true);
                mediumRadioButton.setDisable(true);
                hardRadioButton.setDisable(true);
                playerStartsRadioButton.setDisable(true);
                botStartsRadioButton.setDisable(true);
            } else if (newValue == botRadioButton) {
                // Odblokowanie opcji dla bota
                easyRadioButton.setDisable(false);
                mediumRadioButton.setDisable(false);
                hardRadioButton.setDisable(false);
                playerStartsRadioButton.setDisable(false);
                botStartsRadioButton.setDisable(false);
            }
        });

        Button startButton = new Button("Rozpocznij grę");
        startButton.setOnAction(event -> {
            // Zapisanie wybranych wartości trudności i kto zaczyna
            difficultyToggle = difficultyToggleGroup.getSelectedToggle();
            startsToggle = startsToggleGroup.getSelectedToggle();

            // Zamknięcie okna ustawień
            settingsStage.close();

            // Utworzenie instancji BigBoard i wyświetlenie planszy gry
            BigBoard bigBoard = new BigBoard(difficultyToggle, startsToggle);
            Scene gameScene = bigBoard.createScene(difficultyToggle, startsToggle);

            // Ustawienie sceny w bieżącym oknie
            primaryStage.setScene(gameScene);
            primaryStage.show();
        });

        // Utworzenie kontenera VBox
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                new Label("Z KIM CHCESZ GRAĆ?"),
                humanRadioButton,
                botRadioButton,
                new Label("POZIOM TRUDNOŚCI"),
                easyRadioButton,
                mediumRadioButton,
                hardRadioButton,
                new Label("KTO ZACZYNA"),
                playerStartsRadioButton,
                botStartsRadioButton,
                startButton
        );

        // Utworzenie sceny
        Scene scene = new Scene(vbox, 320, 400);

        // Ustawienie sceny w oknie ustawień
        settingsStage.setScene(scene);
        settingsStage.showAndWait();

        // Zwrócenie wartości true po kliknięciu przycisku "Rozpocznij grę"
        return true;
    }
}

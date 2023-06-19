package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main App");

        // Utworzenie instancji klasy SettingsWindow
        SettingsWindow settingsWindow = new SettingsWindow();

        // Wywołanie metody displaySettingsWindow w klasie SettingsWindow
        boolean startGame = settingsWindow.displaySettingsWindow(primaryStage);

    }
}

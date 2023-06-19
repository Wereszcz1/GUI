package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class BasicBoard {

    public Scene createScene() {
        GridPane gridPane = createGridPane();
        Scene scene = new Scene(gridPane, 320, 320);
        return scene;
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        int buttonCount = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                SquareButton button = new SquareButton();
                GridPane.setRowIndex(button, row);
                GridPane.setColumnIndex(button, col);
                gridPane.getChildren().add(button);
                buttonCount++;
            }
        }

        return gridPane;
    }
}

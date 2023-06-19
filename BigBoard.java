package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class BigBoard {
    private Toggle difficultyToggle;
    private Toggle startsToggle;

    public BigBoard(Toggle difficultyToggle, Toggle startsToggle) {
        this.difficultyToggle = difficultyToggle;
        this.startsToggle = startsToggle;
    }
    public Scene createScene(Toggle difficultyToggle, Toggle startsToggle) {
        GridPane gridPane = createGridPane();
        Scene scene = new Scene(gridPane, 960, 960);
        // Wykorzystaj przekazane wartości trudności i kto zaczyna
        // do dalszej logiki gry, jeśli jest to wymagane
        return scene;
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        int basicBoardCount = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Node basicBoard = createBasicBoard();
                GridPane.setRowIndex(basicBoard, row);
                GridPane.setColumnIndex(basicBoard, col);
                gridPane.getChildren().add(basicBoard);
                basicBoardCount++;
            }
        }

        return gridPane;
    }

    private Node createBasicBoard() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                SquareButton button = new SquareButton();
                GridPane.setRowIndex(button, row);
                GridPane.setColumnIndex(button, col);
                gridPane.getChildren().add(button);
            }
        }

        StackPane stackPane = new StackPane(gridPane);
        stackPane.setStyle("-fx-border-color: black");

        return stackPane;
    }
}

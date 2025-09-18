package com.example.escriturarapida;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatisticController {

    @FXML
    private Label levelStatic;

    @FXML
    private Label correctLabel;

    @FXML
    private Label errorLabel;

    public void setStats(int level, int correctWords, int errors) {
        levelStatic.setText("Nivel: " + level);
        correctLabel.setText("Aciertos: " + correctWords);
        errorLabel.setText("Errores: " + errors);
    }
}

package com.example.escriturarapida;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StatisticController {

    @FXML
    private AnchorPane statisticPane;

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

    @FXML
    private void backMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escriturarapida/view/Menu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) statisticPane.getScene().getWindow();
        stage.setScene(new Scene(root, 680, 680 ));
    }


}

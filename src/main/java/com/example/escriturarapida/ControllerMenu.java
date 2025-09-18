package com.example.escriturarapida;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerMenu {
    @FXML
    private VBox menu;

    @FXML
    public Button playButton;

    @FXML
    public Button helpButton;

    @FXML
    private void Swap() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escriturarapida/view/Game.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(new Scene(root, 680, 680 ));
    }

    @FXML
    private void SwapHelp() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escriturarapida/view/Help.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) menu.getScene().getWindow();
        stage.setScene(new Scene(root, 670, 675));
    }
}


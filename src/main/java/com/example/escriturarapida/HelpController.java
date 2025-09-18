package com.example.escriturarapida;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class HelpController {

    @FXML
    private Label helpLabel;

    @FXML
    private VBox helpInterface;

    private final String rulesLabel =
            "1. Escribe la palabra que se muestra en pantalla antes de que se acabe el tiempo\n" +
                    "2. Presiona la tecla Enter para validar tu respuesta\n" +
                    "3. Si hay un error en la palabra o se te acaba el tiempo, pierdes el nivel\n" +
                    "4. Al principio del juego tienes 20 segundos, cada 5 niveles se te ira disminuyendo 2 segundos";

    @FXML
    public void initialize() {
            helpLabel.setWrapText(true);
            helpLabel.setText(rulesLabel);
    }

    @FXML
    private void MenuSwap() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escriturarapida/view/Menu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) helpInterface.getScene().getWindow();
        stage.setScene(new Scene(root, 680, 680));
        stage.show();
    }
}




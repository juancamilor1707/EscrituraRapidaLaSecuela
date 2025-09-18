package com.example.escriturarapida;

import com.example.escriturarapida.Class.Game;
import com.example.escriturarapida.Class.Player;
import com.example.escriturarapida.Class.Word;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class GameController {

    @FXML
    private Label wordLabel;

    @FXML
    private Label levelLabel;

    @FXML
    private Label timerLabel;

    @FXML
    private TextField answerField;

    private Game game;
    private int errors = 0;
    private int correctWords = 0;

    @FXML
    public void initialize() {
        // Crear jugador y lista de palabras
        Player player = new Player();
        Word word = new Word();
        game = new Game(player, word);

        // Acción con ENTER en el TextField
        answerField.setOnAction(e -> validateWord());

        // Mostrar la primera palabra
        showWord();

        // Iniciar timer
        startTimer();
    }

    /** Muestra la palabra y nivel en pantalla */
    private void showWord() {
        wordLabel.setText(game.getCurrentWord());
        levelLabel.setText("Nivel " + game.getLevel());
        answerField.clear();
    }

    /** Arranca el temporizador de este turno */
    private void startTimer() {
        game.startTimer(
                () -> timerLabel.setText("Tiempo: " + game.getRemainingTime()),
                () -> {
                    try {
                        goToStatistics();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    /** Valida lo que el jugador escribió */
    @FXML
    private void validateWord() {
        String correct = wordLabel.getText();
        String userInput = answerField.getText();

        if (game.getPlayer().wordVerification(correct, userInput)) {
            // Palabra correcta
            correctWords++;
            game.nextWord();
            showWord();
            startTimer();
        } else {
            // Palabra incorrecta
            errors++;
            String oldText = wordLabel.getText();
            wordLabel.setText("¡Palabra incorrecta!");
            answerField.clear();

            PauseTransition pause = new PauseTransition(Duration.seconds(0.6));
            pause.setOnFinished(e -> wordLabel.setText(oldText));
            pause.play();
        }
    }

    private void goToStatistics() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/escriturarapida/view/Stadistics.fxml"));
        Parent root = loader.load();

        StatisticController controller = loader.getController();
        controller.setStats(game.getLevel(), correctWords, errors);

        Stage stage = (Stage) wordLabel.getScene().getWindow();
        stage.setScene(new Scene(root, 634, 630));
        stage.show();
    }
}

package com.example.escriturarapida;

import com.example.escriturarapida.models.Game;
import com.example.escriturarapida.models.Player;
import com.example.escriturarapida.models.Word;
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
        // Create player and wordlist
        Player player = new Player();
        Word word = new Word();
        game = new Game(player, word);

        // Enter action on TextField
        answerField.setOnAction(e -> validateWord());

        // Shows first word
        showWord();

        // Start timer
        startTimer();
    }

    /** Shows word and level on screen */
    private void showWord() {
        wordLabel.setText(game.getCurrentWord());
        answerField.clear();
    }

    /** Starts the timer */
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

    /** Validates player answer */
    @FXML
    private void validateWord() {
        String correct = wordLabel.getText();
        String userInput = answerField.getText();

        if (game.getPlayer().wordVerification(correct, userInput)) {
            // Correct Word
            correctWords++;
            wordLabel.setText("¡Palabra Correcta!");

            PauseTransition pause = new PauseTransition(Duration.seconds(0.3));
            pause.setOnFinished(e -> wordLabel.setText(game.getCurrentWord()));
            pause.play();

            levelLabel.setText("Nivel " + game.getLevel());
            game.nextWord();
            answerField.clear();
            startTimer();
        } else {
            // Incorrect Word
            errors++;
            String oldText = wordLabel.getText();
            wordLabel.setText("¡Palabra incorrecta!");

            PauseTransition pause = new PauseTransition(Duration.seconds(0.6));
            pause.setOnFinished(e -> wordLabel.setText(oldText));
            answerField.clear();
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

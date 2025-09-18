package com.example.escriturarapida.Class;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Game {
    private final Player player;
    private final Word word;

    private int easyIndex = 0;
    private int mediumIndex = 0;
    private int hardIndex = 0;

    private int baseTime = 20;   // Tiempo inicial por palabra
    private int remainingTime;   // Tiempo que va bajando
    private Timeline timeline;   // Cronómetro

    public Game(Player player, Word word) {
        this.player = player;
        this.word = word;
    }

    /** Devuelve la palabra actual según el nivel del jugador */
    public String getCurrentWord() {
        List<String> list = getListByLevel();
        int idx = getIndexByLevel();

        if (idx < list.size()) {
            return list.get(idx);
        }
        return "";
    }

    /** Avanza a la siguiente palabra y ajusta nivel/tiempo */
    public void nextWord() {
        if (player.getLevel() <= 15) {
            easyIndex++;
        } else if (player.getLevel() <= 30) {
            mediumIndex++;
        } else {
            hardIndex++;
        }

        // Cada 5 niveles reduce el tiempo base
        if (player.getLevel() % 5 == 0 && baseTime > 2) {
            baseTime -= 2;
        }

        player.nextLevel();
    }

    /** Obtiene la lista de palabras según el nivel */
    private List<String> getListByLevel() {
        if (player.getLevel() <= 15) {
            return word.getEasy();
        } else if (player.getLevel() <= 30) {
            return word.getMedium();
        } else {
            return word.getHard();
        }
    }

    /** Obtiene el índice correcto según la dificultad */
    private int getIndexByLevel() {
        if (player.getLevel() <= 15) {
            return easyIndex;
        } else if (player.getLevel() <= 30) {
            return mediumIndex;
        } else {
            return hardIndex;
        }
    }

    /**
     * Arranca un nuevo timer.
     * @param onTick   acción a ejecutar cada segundo
     * @param onFinish acción a ejecutar cuando el tiempo llega a 0
     */
    public void startTimer(Runnable onTick, Runnable onFinish) {
        // Detener si ya había un timer activo
        if (timeline != null) {
            timeline.stop();
        }

        remainingTime = baseTime;

        // Crear timeline (1 segundo)
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    remainingTime--;
                    onTick.run(); // actualiza UI
                    if (remainingTime <= 0) {
                        timeline.stop();
                        onFinish.run(); // termina el juego
                    }
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // --- Getters ---
    public int getRemainingTime() {
        return remainingTime;
    }

    public int getLevel() {
        return player.getLevel();
    }

    public Player getPlayer() {
        return player;
    }
}

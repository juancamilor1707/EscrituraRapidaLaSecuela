package com.example.escriturarapida.models;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.List;

public class Game  {
    private final Player player;
    private final Word word;

    private int easyIndex = 0;
    private int mediumIndex = 0;
    private int hardIndex = 0;

    private int baseTime = 20;   // Inicial time per word
    private int remainingTime;   // Time remaining
    private Timeline timeline;   // Timer

    public Game(Player player, Word word) {
        this.player = player;
        this.word = word;
    }

    public String getCurrentWord() {
        List<String> list = getListByLevel();
        int idx = getIndexByLevel();

        if (idx < list.size()) {
            return list.get(idx);
        }
        return "";
    }

    /** Goes to the next level and adjust the level/timer */
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

    /** Obtains word list based on difficulty */
    private List<String> getListByLevel() {
        if (player.getLevel() <= 15) {
            return word.getEasy();
        } else if (player.getLevel() <= 30) {
            return word.getMedium();
        } else {
            return word.getHard();
        }
    }

    /** Obtains correct index based on difficulty */
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
     * Starts new timer
     * @param onTick
     * @param onFinish
     */
    public void startTimer(Runnable onTick, Runnable onFinish) {
        // Stops when timer = 0/null<
        if (timeline != null) {
            timeline.stop();
        }

        remainingTime = baseTime;

        // Start timeline (1s)
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    remainingTime--;
                    onTick.run(); //  UI update
                    if (remainingTime <= 0) {
                        timeline.stop();
                        onFinish.run(); // ends game
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

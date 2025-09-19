package com.example.escriturarapida.models;

public class Player {
    private int level = 1;

    public int getLevel() {
        return level;
    }

    public void nextLevel() {
        level++;
    }

    public boolean wordVerification(String correctWord, String userWord) {
        if (correctWord == null) return false;
        return correctWord.equalsIgnoreCase(userWord == null ? "" : userWord.trim());
    }
}

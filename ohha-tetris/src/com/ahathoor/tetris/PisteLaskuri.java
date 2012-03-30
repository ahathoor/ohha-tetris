/*
 * PisteLaskuri
 */
package com.ahathoor.tetris;

/**
 *
 * @author ahathoor
 */
public class PisteLaskuri {
    private int score;
    private int multiplier;
    public PisteLaskuri() {
        score = 0;
        multiplier = 1;
    }
    public void add(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return "" + score;
    }
    
}

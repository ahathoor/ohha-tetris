/*
 * PisteLaskuri
 */
package com.ahathoor.tetris;

/**
 *
 * @author ahathoor
 */
public class PisteLaskuri {
    private double score;
    public double multiplier;
    public PisteLaskuri() {
        score = 0;
        multiplier = 1;
    }
    public void add(int points) {
        score += points;
    }

    public int getScore() {
        return (int) score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "" + (int) score;
    }
    
}

/*
 * PisteLaskuri
 */
package com.ahathoor.tetris.logic;

/**
 *
 * @author ahathoor
 */
public class PisteLaskuri {
    private double score;
    public double multiplier;
    private String modename;
    public PisteLaskuri(String modename) {
        this.modename = modename;
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

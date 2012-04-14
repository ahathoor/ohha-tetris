// 1. harjoitukset, tehtävä 1.1, Mikko Tamminen
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui.painters;

import com.ahathoor.tetris.highscore.HighScores;
import com.ahathoor.tetris.highscore.Score;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class HighScorePainter {
    private HighScores scores;
    private String game;
    int offX;
    int offY;
    int width;
    int height;
    int fontSize;

    public HighScorePainter(HighScores scores, String game, int offX, int offY, int width, int height, int fontSize) {
        this.scores = scores;
        this.game = game;
        this.offX = offX;
        this.offY = offY;
        this.width = width;
        this.height = height;
        this.fontSize = fontSize;
    }
    
    public void paint(Graphics g){
        int i = 0;
        for (Score sc : scores.sortedScore(game)) {
            g.setColor(Color.yellow);
            char[] name = sc.getName().toCharArray();
            char[] score = ("" + sc.getScore()).toCharArray();
            g.setFont(new Font("Arial",Font.BOLD,fontSize));
            g.drawChars(name, 0, name.length, offX, offY+i);
            g.drawChars(score, 0, score.length, offX+width-(score.length*fontSize), offY+i);
            i += height/10;
        }
        char[] moodi = ("\"" + game + "\"").toCharArray();
        g.drawChars(moodi, 0, moodi.length, offX, offY+height+fontSize);
    }
}

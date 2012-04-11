/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author ahathoor
 */
public class LoseScreenPainter {
    private char[] row1 = "THOU".toCharArray();
    private char[] row2 = "HAST".toCharArray();
    private char[] row3 = "LOST".toCharArray();
    private char[] row4 = "F2 to start a new game".toCharArray();
    
    public void paint(Graphics g, int score) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 380, 500);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawChars(row1, 0, row1.length, 10, 80);
        g.drawChars(row2, 0, row2.length, 10, 180);
        g.drawChars(row3, 0, row3.length, 10, 280);
        g.setFont(new Font("Arial",Font.BOLD,10));
        char[] row5 = ("Thine Score Was " + score).toCharArray();
        g.drawChars(row5, 0, row5.length, 10, 300);
        g.drawChars(row4, 0, row4.length, 10, 315);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.gui.painters.HighScorePainter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

    
/**
 *
 * @author ahathoor
 */
public class LosePanel extends PeliPanel {
    private char[] row1 = "THOU".toCharArray();
    private char[] row2 = "HAST".toCharArray();
    private char[] row3 = "LOST".toCharArray();
    private char[] row4 = "F2 to go to menu".toCharArray();
    
    private int score;
    private String game;
    private HighScorePainter hspaint;

    public LosePanel(MainWindow kutsuva,String game, int score) {
        super(kutsuva);
        setVisible(true);
        this.game = game;
        this.score = score;
        hspaint = new HighScorePainter(kutsuva.getHighScores(), game, 150, 300, 200, 150, 10);
    }
    @Override
    public void tick() {
        super.tick();
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 380, 500);
        
        g.setColor(Color.red);
        
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,100));
        g.drawChars(row1, 0, row1.length, 10, 80);
        g.drawChars(row2, 0, row2.length, 10, 180);
        g.drawChars(row3, 0, row3.length, 10, 280);
        g.setFont(new Font("Arial",Font.BOLD,10));
        char[] row5 = ("Thine Score Was " + score).toCharArray();
        g.drawChars(row5, 0, row5.length, 10, 300);
        g.drawChars(row4, 0, row4.length, 10, 315);
        hspaint.paint(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode()==113)
            kutsuvaIkkuna.usePanel(new MenuPanel(kutsuvaIkkuna));
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    }
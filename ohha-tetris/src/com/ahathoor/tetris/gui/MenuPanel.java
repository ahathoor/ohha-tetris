/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ahathoor
 */
public class MenuPanel extends PeliPanel {
    private int number = 1;
    
    private ArrayList<int[]> points;
    private Random r = new Random();
    private char[] row1 = "WELCOME".toCharArray();
    private char[] row2 = "TO".toCharArray();
    private char[] row3 = "TETTURISSY".toCharArray();
    private char[] row4 = "F2 TO START NEW GAME".toCharArray();

    public MenuPanel(MainWindow kutsuva) {
        super(kutsuva);
        setVisible(true);
        points = new ArrayList<int[]>();
        points.add(new int[] {0,0});
        points.add(new int[] {0,500});
        points.add(new int[] {380,0});
        points.add(new int[] {380,500});
        for (int i = 0; i < 10; i++) {
            points.add(new int[] {r.nextInt(380), r.nextInt(500) });
        }
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 380, 500);
        
        
        
        
        
        double foo = (double) number/5;
        int x = (int) (80*Math.sin(foo));
        int y = (int) (80*Math.cos(foo));
        number++;
        
        g.setColor(Color.pink);
        for (int[] point : points) {
            for (int[] point2 : points) {
                if (point != point2) {
                    g.drawLine(point[0]+x, point[1]-y, point2[0], point2[1]);
                }
            }
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 55));
        g.drawChars(row1, 0, row1.length, 40, 60-y/10);
        g.setFont(new Font("Arial", Font.BOLD, 70));
        g.drawChars(row2, 0, row2.length, 115+x, 175+y);
        g.setFont(new Font("Arial", Font.BOLD, 55));
        g.drawChars(row3, 0, row3.length, 10-x/10, 300);
        g.setFont(new Font("Arial", Font.BOLD, 15));
        g.drawChars(row4, 0, row4.length, 150-100/(number/100+1), 390);
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode()==113) 
            kutsuvaIkkuna.usePanel(kutsuvaIkkuna.CLASSICRUUTU);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

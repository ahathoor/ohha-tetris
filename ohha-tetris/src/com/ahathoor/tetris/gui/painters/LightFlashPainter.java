/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui.painters;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mkctammi
 */
public class LightFlashPainter {
    public static void paint(Graphics g,int offX, int offY, int width, int height, int alpha) {
        for(int i = 1;i<10;i++) {
            g.setColor(new Color(255,255,0,alpha/i));
            g.fillRect(offX-10*i, offY-3*i, width+20*i, height+6*i);
        }
    }
}

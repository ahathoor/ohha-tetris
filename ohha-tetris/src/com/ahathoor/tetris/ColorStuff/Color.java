// 1. harjoitukset, tehtävä 1.1, Mikko Tamminen
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.ColorStuff;

/**
 *
 * @author User
 */
public class Color {
    public static final Color BLUE = new Color(0,0,255,255);
    public static Color black = new Color(0,0,0,255);
    public static Color white = new Color(255,255,255,255);
    private int r;
    private int g;
    private int b;
    private int alpha;
    public Color(int r, int g, int b, int alpha) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.alpha = alpha;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    /**
     * returns an awt usable color
     * @return 
     */
    public java.awt.Color getAwtColor() {
        return new java.awt.Color(r,g,b,alpha);
    }
    
}

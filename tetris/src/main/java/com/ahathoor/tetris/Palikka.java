/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

/**
 *
 * @author mkctammi
 */
public class Palikka {
    /** Palikka määrittelee tetriskentän yhdessä lokerossa asustavan olion,
     *  onko se tyhjä, mikä sen väri on, ja onko se vielä liikkeessä.
     */
    
    private int[] color;
    private int[] defaultColor = new int[] {100,200,0};
    
    private boolean stopped;
    private boolean filled;
    
    public Palikka(boolean f) throws Exception {
        filled = f;
        color = new int[3];
        setColor(defaultColor);
        stopped = false;
    }
    
    public void setColor(int[] rgb) throws Exception {
        /**
         * asettaa palikan värin.
         */
        if (rgb.length != 3) {
            throw new Exception(rgb + "-Argumentti sisälsi väärän määrän arvoja");
                }
        for (int i = 0;i<3;i++){
            if (rgb[i] > 255 || 0 > rgb[i]) throw new Exception("Väriarvojen tulee olla väliltä 0-255");
            else color[i] = rgb[i];
        }
        
    }
    public boolean isEmpty(){
        /**
         * palauttaa palikan tyhjyyden totuusarvona
         */
        return !filled;
    }
    public void setFilled(boolean f){
        /**
         * täyttää/tyhjentää palikan
         */
        filled = f;
    }
    
    public void setStopped(boolean s) {
        /**
         * Pysäyttää/käynnistää palikan
         */
        stopped = s;
    }
}

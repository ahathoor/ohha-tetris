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
    private boolean empty;
    
    public Palikka() {
        empty = true;
        color = new int[3];
        setColor(defaultColor);
        stopped = true;
    }
    /**
     * Säätää palikan värin väriksi int[] {r,g,b}, jossa väriarvot menevät välillä
     * 0-255, jos arvoja tämän välin ulkopuolelta niin ei tee mitään.
     * @param rgb
     * @throws Exception 
     */
    public void setColor(int[] rgb){
        if (rgb.length != 3) {
            return;
                }
        for (int i = 0;i<3;i++){
            if (rgb[i] > 255 || 0 > rgb[i]) return;
            else color[i] = rgb[i];
        }
        
    }    
    /**
     * Palauttaa palikan värin int[] {Xr,Xg,Xb} 0<=X<=255
     * @return 
     */
    public int[] getColor() {
        return color;
    }
    /**
     * Palauttaa palikan tyhjyyden totuusarvona
     * @return 
     */
    public boolean isEmpty(){

        return empty;
    }
    /**
     * Palauttaa palikan pysähtyneisyyden totuusarvona
     * @return 
     */
    public boolean isStopped() {
        return stopped;
    }
    /**
     * Täyttää/Tyhjentää palikan
     * @param f 
     */
    public void setFilled(boolean f){
        empty = !f;
    }
    /**
     * Pysäyttää/Käynnistää palikan
     * @param s 
     */
    public void setStopped(boolean s) {
        stopped = s;
    }
    /**
     * Tyhjentää palikan
     */
    public void clear() {
        stopped = true;
        empty = true;
    }
    /**
     * Kopioi attribuutit joltain palikalta p
     * @param p 
     */
    public void copyAttributes(Palikka p) {
        stopped = p.isStopped();
        empty = p.isEmpty();
        color = p.getColor();
    }
}

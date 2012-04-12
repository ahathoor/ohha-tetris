/*
 * Palikka määrittelee tetriskentän yhdessä lokerossa asustavan olion,
 *  onko se tyhjä, mikä sen väri on, ja onko se vielä liikkeessä.
 */
package com.ahathoor.tetris.Board;

import java.awt.Color;

/**
 *
 * @author mkctammi
 */
public class Palikka {
    private Color color;
    
    private boolean stopped;
    private boolean empty;
    public boolean ghost = false;
    public Color ghostcolor = new Color(0,255,255,100);
    /**
     * Luo uuden Palikkaolion joka käyttää oletusväriä
     */
    public Palikka() {
        empty = true;
        color = Color.BLUE;
        stopped = true;
    }
    /**
     * Luo annetun rgb värikoodin värisen palikan
     * @param rgb 
     */
    public Palikka(Color color) {
        empty = false;
        this.color = color;
        stopped = true;
    }
    /**
     * Säätää palikan värin
     * @param rgb Väriarvo muotoa {0..255,0..255,0..255}
     */
    public void setColor(Color color){
        this.color = color;        
    }    
    /**
     * Palauttaa palikan värin
     * @return 
     */
    public Color getColor() {
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
     * Palauttaa kopion itsestään
     * @return kopio tästä palikasta
     */
    public Palikka getCopy() {
        Palikka palautus = new Palikka();
        palautus.copyAttributes(this);
        return palautus;
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

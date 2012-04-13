/*
 * sisältää x,y koordinaattipareja jotka 
 * ovat suhteellisia sijainteja palikan keskipisteestä
 */
package com.ahathoor.tetris.PalikkaMuodot;

import java.util.ArrayList;

/**
 *
 * @author ahathoor
 */
public class PalikkaMuoto extends ArrayList<int[]>{
    private int[] min = {Integer.MAX_VALUE,Integer.MAX_VALUE};
    private int[] max = {Integer.MIN_VALUE,Integer.MIN_VALUE};
    public PalikkaMuoto() {
    }
    /**
     * Lisää palikan muotoon annettuihin koordinaatteihin
     * @param x
     * @param y
     */
    public void add(int x,int y) {
        if (x>max[0]) max[0] = x;
        if (y>max[1]) max[1] = y;
        if (x<min[0]) min[0] = x;
        if (y<min[1]) min[1] = y;
        super.add(new int[] {x,y});
    }
    public PalikkaMuoto mirror() {
        float xmedian = ((float) max[0] + (float) min[0] )/2;
        PalikkaMuoto palautus = new PalikkaMuoto();
        for (int[] arvo: this) {
            float x = xmedian - ((float) arvo[0] - xmedian);
            palautus.add((int)x,arvo[1]);
        }
        return palautus;
    }
    public PalikkaMuoto turn() {
        PalikkaMuoto palautus = new PalikkaMuoto();
        for (int[] arvo: this) {
            palautus.add(arvo[1],arvo[0]);
        }
        return palautus;
    }
    public PalikkaMuoto embiggen(boolean x, boolean y) {
        PalikkaMuoto palautus = new PalikkaMuoto();
        for (int[] arvo: this) {
            if(y && y) {
                palautus.add(arvo[0]*2,arvo[1]*2);
                palautus.add(arvo[0]*2,arvo[1]*2+1);
                palautus.add(arvo[0]*2+1,arvo[1]*2);
                palautus.add(arvo[0]*2+1,arvo[1]*2+1);
            }
            if (x && !y) {
                palautus.add(arvo[0]*2,arvo[1]);
                palautus.add(arvo[0]*2+1,arvo[1]);               
            }
            if (y && !x) {
                palautus.add(arvo[0],arvo[1]*2);
                palautus.add(arvo[0],arvo[1]*2+1);               
            }
        }
        return palautus;
        
    }
    public void print() {
        for (int[] arvo : this) {
            System.out.println("{" + arvo[0] + "," + arvo[1] + "}");
        }
    }
    
    
}

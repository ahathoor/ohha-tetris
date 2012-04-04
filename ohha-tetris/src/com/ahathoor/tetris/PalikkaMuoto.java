/*
 * sisältää x,y koordinaattipareja jotka 
 * ovat suhteellisia sijainteja palikan keskipisteestä
 */
package com.ahathoor.tetris;

import java.util.ArrayList;

/**
 *
 * @author ahathoor
 */
public class PalikkaMuoto extends ArrayList<int[]>{
    PalikkaMuoto() {
    }
    /**
     * Lisää palikan muotoon annettuihin koordinaatteihin
     * @param x
     * @param y
     */
    public void add(int x,int y) {
        super.add(new int[] {x,y});
    }
    
}

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
    public void add(int x,int y) {
        super.add(new int[] {x,y});
    }
    
}

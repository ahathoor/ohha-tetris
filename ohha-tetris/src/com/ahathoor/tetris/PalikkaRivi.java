/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import java.util.ArrayList;

/**
 *
 * @author mothi
 */
public class PalikkaRivi {
    /**
     * Säilyttää rivillisen tetrispalikoita
     */
    private ArrayList<Palikka> palikat = new ArrayList<Palikka>();
    public PalikkaRivi(int pituus) throws Exception {
        /*
         * Luo uuden int pituus pituisen palikkarivin
         */
        for (int i = 0;i<=pituus;i++){
            //lisätään tyhjiä palikoita
            palikat.add(new Palikka());
        }
    }

    public ArrayList<Palikka> getPalikat() {
        return palikat;
    }
    
}

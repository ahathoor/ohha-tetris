/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris;

import java.util.ArrayList;

/**
 * Sisältää rivillisen palikoita jota TetrisAlusta voi käyttää
 * @author mothi
 */
public class PalikkaRivi {
    private ArrayList<Palikka> palikat = new ArrayList<Palikka>();
/**
 * Luo uuden _pituus_ pituisen PalikkaRivin, pituus = [1,100]
 * @param pituus 
 */
    public PalikkaRivi(int pituus){
        if (pituus<0) pituus = 1;
        if (pituus>100) pituus = 100;
        for (int i = 0;i<pituus;i++){
            //lisätään tyhjiä palikoita
            palikat.add(new Palikka());
        }
    }
/**
 * Palauttaa palikat ArrayListina
 * @return 
 */
    public ArrayList<Palikka> getPalikat() {
        return palikat;
    }
    /**
     * Palauttaa rivin pituuden
     * @return 
     */
    public int getSize() {
        return palikat.size();
    }
    
}

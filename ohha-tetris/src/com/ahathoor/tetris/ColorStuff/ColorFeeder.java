/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.ColorStuff;


/**
 * Syöttää värejä
 * @author ahathoor
 */
public interface ColorFeeder {
    /**
     * Ottaa argumenttina värin ja syöttää uuden värin
     * @param color
     * @return uusi väri
     */
    abstract public Color nextColor(Color color);
}

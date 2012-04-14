/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.ColorStuff;


/**
 *
 * @author ahathoor
 */
public class JustYellow implements ColorFeeder{

    @Override
    public Color nextColor(Color color) {
        return new Color(255,255,0,255);
    }
    
}

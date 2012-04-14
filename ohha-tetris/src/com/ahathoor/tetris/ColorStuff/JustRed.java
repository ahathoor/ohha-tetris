/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.ColorStuff;


/**
 *
 * @author ahathoor
 */
public class JustRed implements ColorFeeder{

    @Override
    public Color nextColor(Color color) {
        return new Color(255,0,0,255);
    }
    
}

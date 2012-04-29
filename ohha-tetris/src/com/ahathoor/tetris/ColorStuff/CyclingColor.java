/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.ColorStuff;


/**
 * Syöttää vaihtelevia värejä
 * @author ahathoor
 */
public class CyclingColor implements ColorFeeder{

    @Override
    public Color nextColor(Color color) {
        int[] c = new int[] {color.getR(),color.getG(),color.getB()};
        if (c[0] != 0 && c[2] == 0) {
            c[1] += 50;
            c[0] -= 50;
        }
        if (c[1] != 0 && c[0] == 0) {
            c[2] += 50;
            c[1] -= 50;
        }
        if (c[2] != 0 && c[1] == 0) {
            c[0] += 50;
            c[2] -= 50;
        }
        for (int i = 0;i<3;i++) {
            if (c[i] < 0) c[i] = 0;
            if (c[i] > 255) c[i] = 255;
        }
        return new Color(c[0],c[1],c[2],255);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.PalikkaMuodot;

import java.util.Random;

/**
 *
 * @author ahathoor
 */
public class PerusMuodotDouble extends PerusMuodot {
    private Random r = new Random();
    @Override
    public PalikkaMuoto getNextShape() {
        if (r.nextBoolean()) return super.getNextShape().embiggen();
        else return super.getNextShape();
    }
    
}

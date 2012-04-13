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
public class MuotoF_MixWithDoubled implements MuotoFeeder {
    private Random r = new Random();
    MuotoFeeder source;

    public MuotoF_MixWithDoubled(MuotoFeeder source) {
        this.source = source;
    }
    
    @Override
    public PalikkaMuoto getNextShape() {
        if (r.nextBoolean()) return source.getNextShape().embiggen(true,true);
        else return source.getNextShape();
    }
    
}

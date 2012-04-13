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
public class MuotoF_MixWithStretcheds implements MuotoFeeder {
    private Random r = new Random();
    MuotoFeeder source;

    public MuotoF_MixWithStretcheds(MuotoFeeder source) {
        this.source = source;
    }
    
    @Override
    public PalikkaMuoto getNextShape() {
        return source.getNextShape().embiggen(r.nextBoolean(),r.nextBoolean());
    }
    
}

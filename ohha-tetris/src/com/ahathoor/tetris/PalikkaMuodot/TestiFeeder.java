/*
 * Sisältää eri perustetriksen palikat
 */
package com.ahathoor.tetris.PalikkaMuodot;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ahathoor
 */
public class TestiFeeder implements MuotoFeeder {
    public PalikkaMuoto L;
    public PalikkaMuoto Z;
    public PalikkaMuoto L2;
    public PalikkaMuoto Z2;
    public PalikkaMuoto T;
    public PalikkaMuoto box;
    public PalikkaMuoto I;
    public ArrayList<PalikkaMuoto> shapes;
    private Random r = new Random();

    public TestiFeeder() {
        shapes = new ArrayList<PalikkaMuoto>();
        
        I = new PalikkaMuoto();
        I.add(0,0);
        I.add(0,5);
        shapes.add(I);
    }
    @Override
    public PalikkaMuoto getNextShape() {
        int random = r.nextInt(shapes.size());
        return shapes.get(random);
    }
    
    public ArrayList<PalikkaMuoto> getShapes() {
        return shapes;
    }
    
}

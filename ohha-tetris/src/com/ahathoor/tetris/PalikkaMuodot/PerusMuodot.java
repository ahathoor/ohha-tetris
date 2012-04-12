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
public class PerusMuodot implements MuotoFeeder {
    public PalikkaMuoto L;
    public PalikkaMuoto Z;
    public PalikkaMuoto L2;
    public PalikkaMuoto Z2;
    public PalikkaMuoto T;
    public PalikkaMuoto box;
    public PalikkaMuoto I;
    public ArrayList<PalikkaMuoto> shapes;
    private Random r = new Random();

    public PerusMuodot() {
        shapes = new ArrayList<PalikkaMuoto>();
        
        L = new MuotoL();
        L2 = L.mirror();
        Z = new MuotoZ();
        Z2 = Z.mirror();
        box = new MuotoBox();
        I = new MuotoLine();
        T = new MuotoT();
        
        shapes.add(L);
        shapes.add(L2);
        shapes.add(Z);
        shapes.add(Z2);
        shapes.add(T);
        shapes.add(box);
        shapes.add(I);
    }
    @Override
    public PalikkaMuoto getNextShape() {
        int random = r.nextInt(shapes.size());
        return shapes.get(random);
    }
    @Override
    public ArrayList<PalikkaMuoto> getShapes() {
        return shapes;
    }
    
}

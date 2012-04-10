/*
 * Sisältää eri palikkamuotoja tetrispeliin
 */
package com.ahathoor.tetris;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ahathoor
 */
public class PalikkaMuodot {
    public PalikkaMuoto L;
    public PalikkaMuoto Z;
    public PalikkaMuoto L2;
    public PalikkaMuoto Z2;
    public PalikkaMuoto T;
    public PalikkaMuoto box;
    public PalikkaMuoto I;
    public ArrayList<PalikkaMuoto> shapes;
    private Random r = new Random();

    public PalikkaMuoto getRandomShape() {
        int random = r.nextInt(shapes.size());
        return shapes.get(random);
    }
    public PalikkaMuoto getShape(String piece) {
        if ("L".equals(piece)) return L;
        if ("L2".equals(piece)) return L2;
        if ("Z".equals(piece)) return Z;
        if ("Z2".equals(piece)) return Z2;
        if ("T".equals(piece)) return T;
        if ("I".equals(piece)) return I;
        else {
            System.out.println("Pyydettiin jotain hämärää palaa \"" + piece + "\", palautettiin silti I pala");
            return I;
        }
    }
    /**
     * Tämä luokka säilyttää perustetriksen 
     * palikat julkisina PalikkaMuoto-olioina
     */
    public PalikkaMuodot() {
        shapes = new ArrayList<PalikkaMuoto>();
        L = new PalikkaMuoto();    
        L.add(0,0);
        L.add(1,0);
        L.add(2,0);
        L.add(0,1);
        L2 = new PalikkaMuoto();  
        L2.add(0,0);
        L2.add(1,0);
        L2.add(2,0);
        L2.add(2,1);
        Z = new PalikkaMuoto();
        Z.add(0,0);
        Z.add(1,0);
        Z.add(1,1);
        Z.add(2,1);
        Z2 = new PalikkaMuoto();
        Z2.add(1,0);
        Z2.add(2,0);
        Z2.add(0,1);
        Z2.add(1,1);
        box = new PalikkaMuoto();
        box.add(0,0);
        box.add(0,1);
        box.add(1,0);
        box.add(1,1);
        I = new PalikkaMuoto();
        I.add(0,0);
        I.add(1,0);
        I.add(2,0);
        I.add(3,0);
        T = new PalikkaMuoto();
        T.add(0,0);
        T.add(1,0);
        T.add(2,0);
        T.add(1,1);
        
        shapes.add(L);
        shapes.add(L2);
        shapes.add(Z);
        shapes.add(Z2);
        shapes.add(T);
        shapes.add(box);
        shapes.add(I);
    }
    
}

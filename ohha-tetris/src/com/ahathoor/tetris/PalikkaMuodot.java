/*
 * Sisältää eri palikkamuotoja tetrispeliin
 */
package com.ahathoor.tetris;

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
    public PalikkaMuoto line;
    /**
     * Tämä luokka säilyttää perustetriksen 
     * palikat julkisina PalikkaMuoto-olioina
     */
    /**
     * 
     */
    public PalikkaMuodot() {
        L = new PalikkaMuoto();    
        L.add(0,0);
        L.add(1,0);
        L.add(2,0);
        L.add(0,1);
        L2 = new PalikkaMuoto();  
        L2.add(0,1);
        L2.add(1,1);
        L2.add(2,1);
        L2.add(2,2);
        Z = new PalikkaMuoto();
        Z.add(0,0);
        Z.add(1,0);
        Z.add(1,1);
        Z.add(2,1);
        Z2 = new PalikkaMuoto();
        Z2.add(1,0);
        Z2.add(1,1);
        Z2.add(2,1);
        Z2.add(2,2);
        box = new PalikkaMuoto();
        box.add(0,0);
        box.add(0,1);
        box.add(1,0);
        box.add(1,1);
        line = new PalikkaMuoto();
        line.add(0,0);
        line.add(1,0);
        line.add(2,0);
        line.add(3,0);
        T = new PalikkaMuoto();
        T.add(0,0);
        T.add(1,0);
        T.add(2,0);
        T.add(1,1);
    }
    
}

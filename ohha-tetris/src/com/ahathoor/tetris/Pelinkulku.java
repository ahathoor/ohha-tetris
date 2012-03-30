/*
 * Pelinkulku määrittelee säännöt tetriksen pelimoodiin
 */
package com.ahathoor.tetris;

import java.util.Random;

/**
 *
 * @author ahathoor
 */
public class Pelinkulku {
    
    private TetrisAlusta board;
    private int leveys = 10;
    private int korkeus = 20;
    private int cycle = 0;
    private int waitFor = 4;
    private PalikkaMuodot palikkamuodot;
    private Random r = new Random();
    private PisteLaskuri pistelaskuri = new PisteLaskuri();
    
    private int[] nextColor = {250,0,0};
    public Pelinkulku() {
        board = new TetrisAlusta(leveys,korkeus);
        palikkamuodot = new PalikkaMuodot();
    }
    /**
     * Peliä 1 aikayksikkö eteenpäin
     */
    public void step(){
        for (int i=0;i<korkeus;i++) {
            if (!board.onkoLiikkuvia() && board.riviOnTaysi(i)) { 
                board.poistaRivi(i);
                pistelaskuri.add(250);
            }
        }
       if (board.onkoLiikkuvia()) {
           if (cycle < waitFor) cycle++;
           else cycle = 0;
           if(cycle == 0 && !board.shiftBlocks(0, -1)) board.pysaytaKaikki();
       } else {
           board.lisaaMuoto(seuraavaMuoto(), leveys/2, korkeus-1, nextBlock());
           pistelaskuri.add(13);
       }
    }
    private PalikkaMuoto seuraavaMuoto() {
        int random = r.nextInt(6);
        if (random == 0) return palikkamuodot.L;
        if (random == 1) return palikkamuodot.L2;
        if (random == 2) return palikkamuodot.Z;
        if (random == 3) return palikkamuodot.Z2;
        if (random == 4) return palikkamuodot.box;
        else return palikkamuodot.line;
    }
    private Palikka nextBlock() {
        Palikka p = new Palikka();
        p.setFilled(true);
        p.setStopped(false);
        int[] c = nextColor;
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
        p.setColor(c);
        return p;
    }
    public void left() {
        board.shiftBlocks(1, 0);
    }
    public void right() {
        board.shiftBlocks(-1, 0);
    }
    public void up() {
        board.flipBlock();
    }
    public void down() {
        board.shiftBlocks(0, -1);
    }
    public void flip() {
        board.flipBlock();
    }
    public TetrisAlusta getBoard() {
        return board;
    }
    public PisteLaskuri getPistelaskuri() {
        return pistelaskuri;
    }
    
}

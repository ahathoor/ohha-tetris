/*
 * Pelinkulku määrittelee säännöt tetriksen pelimoodiin
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.Board.Palikka;
import com.ahathoor.tetris.Board.TetrisAlusta;

/**
 *
 * @author ahathoor
 */
public class Pelinkulku {
    
    private TetrisAlusta board;
    private TetrisAlusta miniboard;
    private int leveys;
    private int korkeus;
    private int cycle = 0;
    private int scoreCounter = 0;
    private PalikkaMuodot palikkamuodot;
    private PisteLaskuri pistelaskuri = new PisteLaskuri();
    private PalikkaMuoto nextBlockShape;
    private Palikka nextBlockType;
    private TetrisSettings config;
    
    private int[] nextColor = {250,0,0};
    /**
     * Luo uuden pelinkulun
     */
    public Pelinkulku() {
        config = new TetrisSettings();
        leveys = config.BOARDWIDTH;
        korkeus = config.BOARDHEIGHT;
        
        board = new TetrisAlusta(leveys,korkeus,this);
        miniboard = new TetrisAlusta(5,5,this);
        palikkamuodot = new PalikkaMuodot();
           this.shuffleBlock();
           this.shuffleShape();
    }
    /**
     * Peliä 1 aikayksikkö eteenpäin
     */
    public void step(){
        if (!config.RUNNING) return;
        
        if (pistelaskuri.getScore() - scoreCounter > config.NEWLEVELEVERY) {
            scoreCounter += config.NEWLEVELEVERY;
            config.NEWLEVELEVERY *= 1.2;
            pistelaskuri.multiplier *= 1.2;
            if (config.WAITFOR > 0) config.WAITFOR--;
            config.LEVEL++;
        }
        
        
        for (int i=0;i<korkeus;i++) {
            if (!board.onkoLiikkuvia() && board.riviOnTaysi(i)) { 
                board.poistaRivi(i);
                pistelaskuri.add(250);
            }
        }
       if (board.onkoLiikkuvia()) {
           if (cycle < config.WAITFOR) cycle++;
           else cycle = 0;
           if(cycle == 0 && !board.shiftBlocks(0, -1)) board.pysaytaKaikki();
       } else {
           if (!board.lisaaMuoto(nextBlockShape, leveys/2, korkeus-1, nextBlockType)){
               //jos uusi muoto ei mahdu, seuraa häviö
               config.RUNNING = false;
               config.GAMELOST = true;
               return;
           }
           this.shuffleBlock();
           this.shuffleShape();
           miniboard.poistaKaikki();
           miniboard.lisaaMuoto(nextBlockShape, 3, 3, nextBlockType);
           pistelaskuri.add(10);
       }
    }
    
    /**
     * Arpoo millainen seuraava palikkamuoto tulee olemaan
     */
    private void shuffleShape() {
        nextBlockShape = palikkamuodot.getRandomShape();
    }
    /**
     * Vaihtaa tulevan palikan tyyppiä
     */
    private void shuffleBlock() {
        nextBlockType = new Palikka();
        nextBlockType.setFilled(true);
        nextBlockType.setStopped(false);
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
        nextBlockType.setColor(c);
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

    public TetrisAlusta getMiniboard() {
        return miniboard;
    }

    public TetrisSettings getConfig() {
        return config;
    }
    
}

/*
 * Pelinkulku määrittelee säännöt tetriksen pelimoodiin
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.Board.Palikka;
import com.ahathoor.tetris.Board.TetrisAlusta;
import com.ahathoor.tetris.PalikkaMuodot.MuotoFeeder;
import com.ahathoor.tetris.PalikkaMuodot.PalikkaMuoto;
import java.awt.Color;

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
    private MuotoFeeder palikkamuodot;
    private ColorFeeder colorfeeder;
    private PisteLaskuri pistelaskuri;
    private PalikkaMuoto nextBlockShape;
    private Palikka nextBlockType = new Palikka();
    private PerusPeliSettings config;
    /**
     * Luo uuden pelinkulun
     */
    public Pelinkulku(PerusPeliSettings ts) {
        config = ts;
        leveys = config.boardWidth;
        korkeus = config.boardHeight;
        palikkamuodot = config.blockfeeder;
        colorfeeder = config.colorfeeder;
        pistelaskuri = new PisteLaskuri(config.modename);
        board = new TetrisAlusta(leveys,korkeus,this);
        miniboard = new TetrisAlusta(config.miniBoardWidth,config.miniBoardHeight,this);
        this.shuffleBlock();
        this.shuffleShape();
    }
    public void startGame() {
        config.gamelost = false;
        config.running = true;
        board.poistaKaikki();
        pistelaskuri.setScore(0);
        config.waitFor = config.waitFor_init;
    }
    public void pause() {
        config.running = !config.running;
    }
    /**
     * Peliä 1 aikayksikkö eteenpäin
     */
    public void step(){
        if (!config.running) return;
        
        if (pistelaskuri.getScore() - scoreCounter > config.scoreToLevel) {
            scoreCounter += config.scoreToLevel;
            config.scoreToLevel *= config.multiplierGrowX;
            pistelaskuri.multiplier *= config.multiplierGrowX;
            if (config.waitFor > 0) config.waitFor--;
        }
        
        
        for (int i=0;i<korkeus;i++) {
            if (!board.onkoLiikkuvia() && board.riviOnTaysi(i)) { 
                board.tyhjennaRivi(i);
                
                if (config.clearingMakesMovables)
                    board.teeRivitLiikkuviksi(i);
                else {
                    board.poistaRivi(i);
                    i--;
                }
                pistelaskuri.add(config.scoreFromRow);
            }
        }
       if (board.onkoLiikkuvia()) {
           if (cycle < config.waitFor) cycle++;
           else cycle = 0;
           if(cycle == 0 && !board.shiftBlocks(config.gravShift)) board.pysaytaKaikki();
       } else {
           if (!board.lisaaMuoto(nextBlockShape, 
                                config.nextBlockX, config.nextBlockY, 
                                nextBlockType)){
               //jos uusi muoto ei mahdu, seuraa häviö
               config.running = false;
               config.gamelost = true;
               return;
           }
           this.shuffleBlock();
           this.shuffleShape();
           if (config.ghostshapes) {
                board.clearGhosts();
                board.lisaaHaamuMuoto(nextBlockShape, 
                                config.nextBlockX, config.nextBlockY);
           }
           miniboard.poistaKaikki();
           miniboard.lisaaMuoto(nextBlockShape, 
                                miniboard.getLeveys()-1, miniboard.getKorkeus()-1, 
                                nextBlockType);
           pistelaskuri.add(config.scoreFromBlock);
       }
    }
    
    /**
     * Arpoo millainen seuraava palikkamuoto tulee olemaan
     */
    private void shuffleShape() {
        nextBlockShape = palikkamuodot.getNextShape();
    }
    /**
     * Vaihtaa tulevan palikan tyyppiä
     */
    private void shuffleBlock() {
        nextBlockType.setFilled(true);
        nextBlockType.setStopped(false);
        nextBlockType.setColor(colorfeeder.nextColor(nextBlockType.getColor()));
    }
    public void left() {
        boolean foo = board.shiftBlocks(config.leftShift);
        if(foo && config.gliding) glide();
    }
    public void right() {
        boolean foo = board.shiftBlocks(config.rightShift);
        if(foo && config.gliding) glide();
    }
    public void up() {
        board.shiftBlocks(config.upShift);
    }
    public void down() {
        board.shiftBlocks(config.downShift);
    }
    public void flip() {
        board.flipBlock();
    }
    public void glide() {
        cycle -= config.glideAmount;
        if (cycle < 0) cycle = 0;
    }
    public TetrisAlusta getBoard() {
        return board;
    }

    public TetrisAlusta getMiniboard() {
        return miniboard;
    }

    public PerusPeliSettings getConfig() {
        return config;
    }

    public int getScore() {
        return pistelaskuri.getScore();
    }
    
}

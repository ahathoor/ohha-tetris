/*
 * 
 */
package com.ahathoor.tetris.logic;

import com.ahathoor.tetris.Board.Palikka;
import com.ahathoor.tetris.Board.TetrisAlusta;
import com.ahathoor.tetris.ColorStuff.ColorFeeder;
import com.ahathoor.tetris.PalikkaMuodot.PalikkaMuoto;

/**
 * hallinnoi lautaa tetrismäiseen tyyliin
 * @author ahathoor
 */
public class Pelinkulku {

    private TetrisAlusta board;
    private TetrisAlusta miniboard;
    private int leveys;
    private int korkeus;
    private int cycle = 0;
    private int scoreCounter = 0;
    private PisteLaskuri pistelaskuri;
    private PalikkaMuoto nextBlockShape;
    private Palikka nextBlockType = new Palikka();
    private Ilmoittaja ilmoittaja = new Ilmoittaja();
    private PeliSettings_Classic config;

    /**
     * Luo uuden pelinkulun
     */
    public Pelinkulku(PeliSettings_Classic ts) {
        config = ts;
        leveys = config.boardWidth;
        korkeus = config.boardHeight;
        pistelaskuri = new PisteLaskuri(config.modename);
        board = new TetrisAlusta(leveys, korkeus);
        miniboard = new TetrisAlusta(config.miniBoardWidth, config.miniBoardHeight);
        this.shuffleBlock();
        this.shuffleShape();
    }

    public void startGame() {
        config.gamelost = false;
        config.running = true;
        board.poistaKaikki();
        pistelaskuri.setScore(0);
        config.waitFor = config.waitFor_init;
        config.level = 1;
        ilmoittaja.nollaa();
        this.shuffleBlock();
        this.shuffleShape();
    }

    public Ilmoittaja getIlmoittaja() {
        return ilmoittaja;
    }

    public void pause() {
        config.running = !config.running;
    }

    /**
     * Peliä 1 aikayksikkö eteenpäin
     */
    public void step() {
        if (!config.running) {
            return;
        }
        ilmoittaja.tick();

        if (pistelaskuri.getScore() - scoreCounter > config.scoreToLevel) {
            scoreCounter += config.scoreToLevel;
            config.scoreToLevel *= config.multiplierGrowX;
            pistelaskuri.multiplier *= config.multiplierGrowX;
            config.level++;
            if (config.waitFor > 0) {
                config.waitFor -= config.gameHardensBy;
            }
        }

        if (!board.onkoLiikkuvia()) {
            boolean[] taydetRivit = new boolean[korkeus];
            for (int j = 0; j < korkeus; j++) {
                taydetRivit[j] = board.riviOnTaysi(j);
                if (taydetRivit[j]) {
                    ilmoittaja.ilmoita("OHYEAUGOTRIVI#" + j, 15);
                    pistelaskuri.add(config.scoreFromRow);
                }
            }
            for (int j = 0; j < korkeus; j++) {
                if (taydetRivit[j]) {
                    if (config.clearingMakesMovables) {
                        board.teeRivitLiikkuviksi(j);
                        board.tyhjennaRivi(j);
                    } else {
                        if (board.riviOnTaysi(j)) {
                            board.poistaRivi(j);
                            j--;
                        }
                    }
                }
            }
        }
        
        if (board.onkoLiikkuvia()) {
            if (cycle < config.waitFor) {
                cycle++;
            } else {
                cycle = 0;
            }
            if (cycle == 0 && !board.shiftBlocks(config.gravShift)) {
                if (config.fallPast) {
                    board.pysaytaRivi(config.lowestRow);
                    board.recursingUnMover();
                    cycle = -1;
                } else {
                    board.pysaytaKaikki();
                }
            }
        } else {
            if (!board.lisaaMuoto(nextBlockShape,
                    config.nextBlockX, config.nextBlockY,
                    nextBlockType)) {
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
                    miniboard.getLeveys() - 1, miniboard.getKorkeus() - 1,
                    nextBlockType);
            pistelaskuri.add(config.scoreFromBlock);
        }
    }

    /**
     * Arpoo millainen seuraava palikkamuoto tulee olemaan
     */
    private void shuffleShape() {
        nextBlockShape = config.blockfeeder.getNextShape();
    }

    /**
     * Vaihtaa tulevan palikan tyyppiä
     */
    private void shuffleBlock() {
        nextBlockType.setFilled(true);
        nextBlockType.setStopped(false);
        nextBlockType.setColor(config.colorfeeder.nextColor(nextBlockType.getColor()));
    }

    public void left() {
        boolean foo = board.shiftBlocks(config.leftShift);
        if (foo && config.gliding) {
            glide();
        }
    }

    public void right() {
        boolean foo = board.shiftBlocks(config.rightShift);
        if (foo && config.gliding) {
            glide();
        }
    }

    public void up() {
        board.shiftBlocks(config.upShift);
    }

    public void down() {
        if (!board.shiftBlocks(config.downShift)) {
            cycle = -1;
        }
    }

    public void flip() {
        board.flipBlock();
    }

    public void glide() {
        cycle -= config.glideAmount;
        if (cycle < 0) {
            cycle = 0;
        }
    }

    public TetrisAlusta getBoard() {
        return board;
    }

    public TetrisAlusta getMiniboard() {
        return miniboard;
    }

    public PeliSettings_Classic getConfig() {
        return config;
    }

    public int getScore() {
        return pistelaskuri.getScore();
    }

    public void stop() {
        if (config.canStopMidFlight) {
            board.pysaytaKaikki();
        }
    }

    public int getLevel() {
        return config.level;
    }

    public void setColorfeeder(ColorFeeder colorfeeder) {
        config.colorfeeder = colorfeeder;
    }
}

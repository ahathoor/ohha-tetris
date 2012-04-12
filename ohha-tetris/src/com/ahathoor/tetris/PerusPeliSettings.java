/*
 * Global settings for the Tetturissy game
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.PalikkaMuodot.*;

/**
 *
 * @author ahathoor
 */
public class PerusPeliSettings {
    public String modename = "Classic Tetturibbli";
    
    public int waitFor_init = 20;
    public int waitFor = 20;
    public float scoreToLevel = 1000;
    public float multiplierGrowX = (float) 1.2;
    public int scoreFromBlock = 10;
    public int scoreFromRow = 290;
    public int boardWidth = 10;
    public int boardHeight = 20;
    public int nextBlockX = 5;
    public int nextBlockY = boardHeight-1;
    public int miniBoardWidth = 4;
    public int miniBoardHeight = 4;
    
    public int[] upShift = {0, 1};
    public int[] downShift = {0, -1};
    public int[] leftShift = {1,0};
    public int[] rightShift = {-1,0};
    public int[] gravShift = {0, -1};
    
    
    public MuotoFeeder blockfeeder = new PerusMuodot();
    public ColorFeeder colorfeeder = new CyclingColor();
    public boolean running = false;
    public boolean gamelost = false;
    public boolean INVISIBULU = false;
    public boolean clearingMakesMovables = false;
    public boolean gliding = true;
    public int glideAmount = 10;
    public boolean ghostshapes = false;
}

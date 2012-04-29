/*

 */
package com.ahathoor.tetris.logic;

import com.ahathoor.tetris.ColorStuff.CyclingColor;
import com.ahathoor.tetris.ColorStuff.ColorFeeder;
import com.ahathoor.tetris.PalikkaMuodot.*;
import java.util.Properties;

/**
 * Global settings for the Classic Tetturissy game
 * @author ahathoor
 */
public class PeliSettings_Classic {
    public String modename = "Classic Tetturibbli";
    
    public int waitFor_init;
    public int waitFor;
    public int level;
    public float scoreToLevel;
    public float multiplierGrowX;
    public int gameHardensBy;
    public int scoreFromBlock;
    public int scoreFromRow;
    public int boardWidth;
    public int boardHeight;
    public int lowestRow;
    public int nextBlockX;
    public int nextBlockY;
    public int miniBoardWidth;
    public int miniBoardHeight;
    
    public int[] upShift;
    public int[] downShift;
    public int[] leftShift;
    public int[] rightShift;
    public int[] gravShift;
    
    
    public MuotoFeeder blockfeeder;
    public ColorFeeder colorfeeder;
    public boolean running;
    public boolean gamelost;
    public boolean INVISIBULU ;
    public boolean clearingMakesMovables;
    public boolean fallPast;
    public boolean gliding;
    public int glideAmount;
    public boolean ghostshapes;
    boolean canStopMidFlight;

    public PeliSettings_Classic() {
        
        modename = "Classic Tetturibbli";
    
        waitFor_init = 20;
        waitFor = 20;
        level = 1;
        scoreToLevel = 1000;
        gameHardensBy = 2;
        multiplierGrowX = (float) 1.2;
        scoreFromBlock = 10;
        scoreFromRow = 290;
        boardWidth = 10;
        boardHeight = 20;
        lowestRow = 0;
        nextBlockX = 5;
        nextBlockY = boardHeight-1;
        miniBoardWidth = 4;
        miniBoardHeight = 4;
    
        upShift = new int[] {0, 0};
        downShift = new int[] {0, -1};
        leftShift = new int[] {1,0};
        rightShift = new int[] {-1,0};
        gravShift = new int[] {0, -1};


        blockfeeder = new PerusMuodot();
        colorfeeder = new CyclingColor();
        running = false;
        gamelost = false;
        INVISIBULU = false;
        clearingMakesMovables = false;
        fallPast = false;
        gliding = true;
        glideAmount = 8;
        ghostshapes = false;
        canStopMidFlight = false;
    }
    
    
}

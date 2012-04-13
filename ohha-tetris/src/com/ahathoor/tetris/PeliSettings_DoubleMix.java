/*
 * Global settings for the Tetturissy game
 */
package com.ahathoor.tetris;

import com.ahathoor.tetris.PalikkaMuodot.*;

/**
 *
 * @author ahathoor
 */
public class PeliSettings_DoubleMix extends PeliSettings_Classic{

    public PeliSettings_DoubleMix() {
        this.modename = "DoubleMix Tetturibbli";
        this.boardWidth = 20;
        this.boardHeight = 40;
        this.nextBlockX = 10;
        this.nextBlockY = boardHeight-1;
        this.miniBoardWidth = 8;
        this.miniBoardHeight = 8;
    
        this.upShift = new int[] {0, 1};
        this.blockfeeder = new MuotoF_MixWithDoubled(new PerusMuodot());
        this.fallPast = true;
        this.clearingMakesMovables = true;
        
    }
}

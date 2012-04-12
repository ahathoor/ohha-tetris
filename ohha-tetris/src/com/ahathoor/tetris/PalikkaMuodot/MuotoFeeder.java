/*
 * Syöttää PalikkaMuotoja Pelinkululle
 */
package com.ahathoor.tetris.PalikkaMuodot;

import java.util.ArrayList;

/**
 *
 * @author ahathoor
 */
public interface MuotoFeeder {
    abstract public PalikkaMuoto getNextShape();
    abstract public ArrayList<PalikkaMuoto> getShapes();
}

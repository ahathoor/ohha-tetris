/*
 * Syöttää PalikkaMuotoja Pelinkululle
 */
package com.ahathoor.tetris.PalikkaMuodot;

import java.util.ArrayList;

/**
 * Syöttää PalikkaMuotoja 
 * @author ahathoor
 */
public interface MuotoFeeder {
    /**
     * syöttää seuraavan palikkamuodon
     * @return uusi palikkamuoto
     */
    abstract public PalikkaMuoto getNextShape();
}

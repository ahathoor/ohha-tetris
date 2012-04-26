/*
 * Interface for a ColorFeeder class, that gives consequent colors
 */
package com.ahathoor.tetris;

import java.awt.Color;

/**
 *
 * @author ahathoor
 */
public interface ColorFeeder {
    abstract public Color nextColor(Color color);
}

/*
 * Erilaisia paneeleja joita tetrispelin pääikkuna voi käyttää
 */
package com.ahathoor.tetris.gui;

import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author ahathoor
 */
public abstract class PeliPanel extends JPanel implements KeyListener {
    final public MainWindow kutsuvaIkkuna;
    public PeliPanel(MainWindow kutsuva) {
        this.kutsuvaIkkuna = kutsuva;
    }
    
    public void tick() {
        this.repaint();
    }
}

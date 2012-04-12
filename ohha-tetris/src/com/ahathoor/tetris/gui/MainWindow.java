/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ahathoor.tetris.gui;

import com.ahathoor.tetris.Pelinkulku;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author ahathoor
 */
public class MainWindow extends JFrame {
    
    private PeliPanel mainpanel;
    private ActionListener tick;
    private Timer timer;
    
    final public PeliPanel MENURUUTU = new MenuPanel(this);
    final public LosePanel TAPPIORUUTU = new LosePanel(this);
    
    final public void usePanel(PeliPanel p) {
        for (KeyListener k : this.getKeyListeners()){
            this.removeKeyListener(k);
        }
        
        if (tick != null) timer.removeActionListener(tick);
        if (mainpanel != null) this.remove(mainpanel);
        mainpanel = p;
        add(mainpanel);
        mainpanel.setPreferredSize(new Dimension(380,500));
        addKeyListener(mainpanel);
        
        tick = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainpanel.tick();
                }
            };
        setVisible(true);
        timer.addActionListener(tick);
        timer.start();
    }
    
    public MainWindow() throws HeadlessException { 
        
        setTitle("TETTURISSY!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380,500);
        timer = new Timer(20, tick);
        this.usePanel(MENURUUTU);
        
    }
}
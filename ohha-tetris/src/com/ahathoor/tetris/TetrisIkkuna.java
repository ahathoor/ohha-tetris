/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mkctammi
 */
public class TetrisIkkuna extends JFrame {
/**
 * Konstruktoi TetrisIkkunan
 * @throws HeadlessException 
 */
    TetrisAlusta pelialusta = new TetrisAlusta();
    final TetrisPanel tetrisPanel = new TetrisPanel(pelialusta);
    
    public TetrisIkkuna() throws HeadlessException, Exception {
        super();
        setTitle("Tetturissy!!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        
        JPanel paneeli = new JPanel();
        tetrisPanel.setPreferredSize(new Dimension(200, 400));
        
        JButton nappi = new JButton();
        nappi.setPreferredSize(new Dimension(100,50));
        
        paneeli.add(tetrisPanel);
        paneeli.add(nappi);
        
        add(paneeli);
        pelialusta.getPalikkaAt(5,5).setStopped(false);
        pelialusta.getPalikkaAt(5,5).setFilled(true);
        nappi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       pelialusta.shiftBlocks();
               tetrisPanel.repaint();
            }
        });
        pack();
        setVisible(true);
    }
    
}

/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    TetrisAlusta pelialusta = new TetrisAlusta(20,20);
    TetrisPanel tetrisPanel = new TetrisPanel(pelialusta);
    
    
    //Action Listeners
    ActionListener alas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       pelialusta.shiftBlocks(0,-1);
               tetrisPanel.repaint();
            }
        };
    ActionListener oikealle = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       pelialusta.shiftBlocks(1,0);
               tetrisPanel.repaint();
            }
        };
    
    public TetrisIkkuna() throws HeadlessException{
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
        pelialusta.LisaaLiikkuvaPalikka(5, 7);
        pelialusta.LisaaLiikkuvaPalikka(5, 6);
        nappi.addActionListener(alas);
        pack();
        setVisible(true);
    }
    
}
   

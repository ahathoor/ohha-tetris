/*
 * Ikkuna johon tetrispelin elementit piirretään
 */
package com.ahathoor.tetris;

import java.awt.Dimension;
import java.awt.HeadlessException;
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
    TetrisAlusta pelialusta = new TetrisAlusta(10,20);
    TetrisPanel tetrisPanel = new TetrisPanel(pelialusta);
    
    
    //Action Listeners
    ActionListener alas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       pelialusta.shiftBlocks(0,-1);
               tetrisPanel.repaint();
            }
        };
    ActionListener kaanna = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	       pelialusta.flipBlock();
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
        pelialusta.LisaaLiikkuvaPalikka(5, 6);
        pelialusta.LisaaLiikkuvaPalikka(5, 7);
        pelialusta.LisaaLiikkuvaPalikka(5, 8);
        pelialusta.LisaaLiikkuvaPalikka(4, 8);
        pelialusta.LisaaLiikkuvaPalikka(8, 12);
        nappi.addActionListener(kaanna);
        pack();
        setVisible(true);
    }
    
}
   
